package nl.living.it.assignment.auth.service;

import liquibase.util.StringUtils;
import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.exception.ExpiredTokenAuthenticationException;
import nl.living.it.assignment.auth.exception.InvalidTokenAuthenticationException;
import nl.living.it.assignment.auth.model.JwtAuthenticationToken;
import nl.living.it.assignment.auth.model.JwtUserDetails;
import nl.living.it.assignment.auth.model.TokenPayload;
import nl.living.it.assignment.model.User;
import nl.living.it.assignment.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private static final long MILLIS_IN_SECOND = 1000L;

    private final UserRepository userRepository;
    private final AuthenticationHelper authenticationHelper;

    @Override
    public Authentication authenticate(final Authentication authRequest) {
        // Getting string token from authentication request object
        final String token = StringUtils.trimToNull((String) authRequest.getCredentials());

        //  Deserialize token
        final TokenPayload tokenPayload = authenticationHelper.decodeToken(token);

        // Checking if token already expired and throwing an AuthenticationException in this case
        checkIsExpired(tokenPayload.getExp());

        // Getting user id from token
        final Long userEntityId = tokenPayload.getUserId();
        if (Objects.isNull(userEntityId)) {
            throw new InvalidTokenAuthenticationException("Token does not contain a user id.");
        }

        // Getting user from database
        final User user = userRepository.findById(userEntityId)
                .orElseThrow(() -> new InvalidTokenAuthenticationException("Token does not contain existed user id."));

        // Return authenticated Authentication
        final JwtUserDetails userDetails = new JwtUserDetails(user);
        return new JwtAuthenticationToken(userDetails);
    }

    private void checkIsExpired(final Long tokenExpirationTime) {
        if ((System.currentTimeMillis() / MILLIS_IN_SECOND) > tokenExpirationTime) {
            throw new ExpiredTokenAuthenticationException();
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
