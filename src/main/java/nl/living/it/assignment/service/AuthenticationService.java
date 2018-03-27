package nl.living.it.assignment.service;

import nl.living.it.assignment.dto.LoginRequestDto;
import nl.living.it.assignment.dto.LoginResponseDto;
import nl.living.it.assignment.dto.UserDto;
import nl.living.it.assignment.exception.EntityNotFoundException;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface AuthenticationService {
    LoginResponseDto login(final LoginRequestDto loginRequestDto);
    UserDto getMe() throws EntityNotFoundException;
}
