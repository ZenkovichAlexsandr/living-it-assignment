package nl.living.it.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.SecurityHelper;
import nl.living.it.assignment.dto.AccountDto;
import nl.living.it.assignment.dto.AccountListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.exception.IllegalEntityStateException;
import nl.living.it.assignment.model.Account;
import nl.living.it.assignment.model.User;
import nl.living.it.assignment.repository.AccountRepository;
import nl.living.it.assignment.repository.UserRepository;
import nl.living.it.assignment.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final UserRepository userRepository;

    @Override
    public List<AccountListDto> findAll() {
        return repository.findAllByUsers(SecurityHelper.getCurrentUserId())
                .stream()
                .map(it -> new AccountListDto(it.getId(), it.getName(), it.getMoney()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto create(final AccountDto account) throws BusinessException {
        validateAccount(account);

        final Set<User> users = account.getUsers()
                .stream()
                .map(this::getUser)
                .collect(Collectors.toSet());

        final Account newAccount = repository.save(new Account(account.getName(), account.getMoney(), users));

        return AccountDto.builder()
                .name(newAccount.getName())
                .money(newAccount.getMoney())
                .users(newAccount.getUsers()
                        .stream()
                        .map(User::getId)
                        .collect(Collectors.toSet()))
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

    private User getUser(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user.not.found", id));
    }
}
