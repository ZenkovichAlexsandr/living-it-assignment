package nl.living.it.assignment.service;

import nl.living.it.assignment.dto.UserDto;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface UserService {
    List<UserDto> lookup();
}
