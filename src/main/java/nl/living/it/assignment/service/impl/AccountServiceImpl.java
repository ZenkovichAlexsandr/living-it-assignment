package nl.living.it.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.SecurityHelper;
import nl.living.it.assignment.dto.AccountDetailsDto;
import nl.living.it.assignment.dto.AccountDto;
import nl.living.it.assignment.dto.AccountListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.exception.IllegalEntityStateException;
import nl.living.it.assignment.model.Account;
import nl.living.it.assignment.model.Transaction;
import nl.living.it.assignment.repository.AccountRepository;
import nl.living.it.assignment.repository.TransactionRepository;
import nl.living.it.assignment.service.AccountService;
import nl.living.it.assignment.service.transformers.AccountListTransformer;
import nl.living.it.assignment.service.transformers.AccountTransformer;
import nl.living.it.assignment.service.transformers.TransactionListTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final AccountTransformer transformer;
    private final AccountListTransformer listTransformer;
    private final UserTransformer userTransformer;
    private final TransactionRepository transactionRepository;
    private final TransactionListTransformer transactionTransformer;

    @Override
    public List<AccountListDto> findAll() {
        return repository.findAllByUsersId(SecurityHelper.getCurrentUserId())
                .stream()
                .map(listTransformer::transform)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto create(final AccountDto account) throws BusinessException {
        validateAccount(account);

        final Account newAccount = repository.save(transformer.transform(account));
        return transformer.transform(newAccount);
    }

    @Override
    public AccountDetailsDto findOne(final Long id) throws EntityNotFoundException {
        final Long userId = SecurityHelper.getCurrentUserId();
        final Account account = Optional.ofNullable(repository.findByIdAndUsersId(id, userId))
                .orElseThrow(() -> new EntityNotFoundException("account.not.found", id));

        final List<Transaction> transactions = transactionRepository
                .findAllByFromIdOrToId(account.getId(), account.getId());

        return AccountDetailsDto.builder()
                .name(account.getName())
                .users(account.getUsers()
                        .stream()
                        .map(userTransformer::transform)
                        .collect(Collectors.toList()))
                .transactions(transactions
                        .stream()
                        .map(transactionTransformer::transform)
                        .collect(Collectors.toList()))
                .build();
    }

    private void validateAccount(final AccountDto account) {
        if (Objects.isNull(account.getUsers()) || account.getUsers().isEmpty()) {
            throw new IllegalEntityStateException("account.users.empty");
        }

        if (account.getMoney() < 0) {
            throw new IllegalEntityStateException("account.money.negative");
        }
    }
}
