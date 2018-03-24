package nl.living.it.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.exception.AuthenticationException;
import nl.living.it.assignment.auth.model.JwtUserDetails;
import nl.living.it.assignment.auth.service.AuthenticationHelper;
import nl.living.it.assignment.dto.LoginRequestDto;
import nl.living.it.assignment.dto.LoginResponseDto;
import nl.living.it.assignment.model.User;
import nl.living.it.assignment.repository.UserRepository;
import nl.living.it.assignment.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationHelper authenticationHelper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
        try {
            final String username = Optional.ofNullable(loginRequestDto.getUsername())
                    .orElseThrow(() -> new BadCredentialsException("Username should be passed."));

            final String password = Optional.ofNullable(loginRequestDto.getPassword())
                    .orElseThrow(() -> new BadCredentialsException("Password should be passed."));

            final UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    password);

            // Try to authenticate with this token
            final Authentication authResult = this.authenticationManager.authenticate(authRequest);

            if (!authResult.isAuthenticated()) {
                throw new AuthenticationException("Authentication failed.");
            }

            // Set generated JWT token to response header
            final JwtUserDetails userDetails = (JwtUserDetails) authResult.getPrincipal();

            final String token = this.authenticationHelper.generateToken(userDetails.getId());

            return new LoginResponseDto(token);

        } catch (BadCredentialsException exception) {
            throw new AuthenticationException("Username or password was incorrect. Please try again.", exception);
        }
    }
}
