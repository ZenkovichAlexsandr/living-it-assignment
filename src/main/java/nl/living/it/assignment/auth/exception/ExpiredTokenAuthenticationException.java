package nl.living.it.assignment.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
public class ExpiredTokenAuthenticationException extends AuthenticationException {

    public ExpiredTokenAuthenticationException() {
        super("Authentication token is expired.");
    }
}
