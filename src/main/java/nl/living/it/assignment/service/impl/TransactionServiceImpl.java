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
import org.springframework.stereotype.Service;

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

    @Override
    public TransactionListDto create(final TransactionDto transaction) throws BusinessException {
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

        return TransactionListDto.builder()
                .from(newTransaction.getFrom().getName())
                .to(newTransaction.getTo().getName())
                .creationDate(newTransaction.getCreationDate())
                .build();
    }

    @Override
    public List<TransactionListDto> findByStatus(final TransactionStatus status) {
        return repository.findByStatusAndFromUsers(status, SecurityHelper.getCurrentUserId())
                .stream()
                .map(it -> new TransactionListDto(it.getId(),
                        it.getCreationDate(),
                        it.getFrom().getName(),
                        it.getTo().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void manage(final Long id, final TransactionStatus status) throws EntityNotFoundException {
        final Transaction transaction = Optional
                .ofNullable(repository.findByIdAndFromUsers(id, SecurityHelper.getCurrentUserId()))
                .orElseThrow(() -> new EntityNotFoundException("transaction.not.found", id));

        transaction.setStatus(status);

        if (status.equals(APPROVED)) {
            transaction.setApprovalDate(LocalDateTime.now());
        }

        repository.save(transaction);
    }

    private Account getAccount(final Long id) throws EntityNotFoundException {
        return Optional.ofNullable(accountRepository.findByUsers(id))
                .orElseThrow(() -> new EntityNotFoundException("account.not.found", id));
    }
}