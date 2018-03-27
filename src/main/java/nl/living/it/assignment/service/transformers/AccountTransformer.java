package nl.living.it.assignment.service.transformers;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.AccountDto;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.model.Account;
import nl.living.it.assignment.model.User;
import nl.living.it.assignment.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Component
@RequiredArgsConstructor
public class AccountTransformer implements DtoTransformer<AccountDto, Account> {
    private final UserRepository userRepository;

    @Override
    public Account transform(final AccountDto dto) {
        final Set<User> users = dto.getUsers()
                .stream()
                .map(this::getUser)
                .collect(Collectors.toSet());

        return Account.builder()
                .name(dto.getName())
                .money(dto.getMoney())
                .users(users)
                .build();
    }

    @Override
    public AccountDto transform(final Account entity) {
        return AccountDto.builder()
                .name(entity.getName())
                .money(entity.getMoney())
                .users(entity.getUsers()
                        .stream()
                        .map(User::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    private User getUser(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user.not.found", id));
    }
}
