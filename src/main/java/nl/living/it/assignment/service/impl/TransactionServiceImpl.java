package nl.living.it.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.SecurityHelper;
import nl.living.it.assignment.dto.TransactionDto;
import nl.living.it.assignment.dto.TransactionListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.exception.IllegalEntityStateException;
import nl.living.it.assignment.model.Account;
import nl.living.it.assignment.model.Transaction;
import nl.living.it.assignment.model.TransactionStatus;
import nl.living.it.assignment.repository.AccountRepository;
import nl.living.it.assignment.repository.TransactionRepository;
import nl.living.it.assignment.service.TransactionService;
import nl.living.it.assignment.service.transformers.TransactionListTransformer;
import nl.living.it.assignment.service.transformers.TransactionTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static nl.living.it.assignment.model.TransactionStatus.APPROVED;
import static nl.living.it.assignment.model.TransactionStatus.NEW;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository repository;
    private final TransactionTransformer transformer;
    private final TransactionListTransformer listTransformer;

    @Override
    public TransactionDto create(final TransactionDto transaction) throws BusinessException {
        if (transaction.getFrom().equals(transaction.getTo())) {
            throw new IllegalEntityStateException("transaction.accounts.same");
        }

        final Account from = getAccount(transaction.getFrom());

        if (from.getMoney() < transaction.getMoney()) {
            throw new IllegalEntityStateException("account.money.not.enough");
        }

        final Transaction newTransaction = repository.save(Transaction.builder()
                .creationDate(LocalDateTime.now())
                .status(NEW)
                .from(from)
                .to(getAccount(transaction.getTo()))
                .money(transaction.getMoney())
                .build());

        return transformer.transform(newTransaction);
    }

    @Override
    public List<TransactionListDto> findByStatus(final TransactionStatus status) {
        return repository.findAllByStatusAndFromUsers_Id(status, SecurityHelper.getCurrentUserId())
                .stream()
                .map(listTransformer::transform)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void manage(final Long id, final TransactionStatus status) throws EntityNotFoundException {
        final Transaction transaction = Optional
                .ofNullable(repository.findByIdAndFromUsers_Id(id, SecurityHelper.getCurrentUserId()))
                .orElseThrow(() -> new EntityNotFoundException("transaction.not.found", id));

        transaction.setStatus(status);

        if (status.equals(APPROVED)) {
            transaction.setApprovalDate(LocalDateTime.now());
        }

        final Account from = transaction.getFrom();
        final Account to = transaction.getTo();

        from.setMoney(from.getMoney() - transaction.getMoney());
        to.setMoney(to.getMoney() + transaction.getMoney());

        repository.save(transaction);
        accountRepository.save(from);
        accountRepository.save(to);
    }

    private Account getAccount(final Long id) throws EntityNotFoundException {
        return Optional.ofNullable(accountRepository.findByIdAndUsersId(id, SecurityHelper.getCurrentUserId()))
                .orElseThrow(() -> new EntityNotFoundException("account.not.found", id));
    }
}
