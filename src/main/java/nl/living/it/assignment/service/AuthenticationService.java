package nl.living.it.assignment.service;

import nl.living.it.assignment.dto.LoginRequestDto;
import nl.living.it.assignment.dto.LoginResponseDto;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface AuthenticationService {
    LoginResponseDto login(final LoginRequestDto loginRequestDto);
}
