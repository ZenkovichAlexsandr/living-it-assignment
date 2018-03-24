package nl.living.it.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.UserListDto;
import nl.living.it.assignment.repository.UserRepository;
import nl.living.it.assignment.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserListDto> lookup() {
        return repository.lookup();
    }
}
