package nl.living.it.assignment.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
public class InvalidTokenAuthenticationException extends AuthenticationException {

    public InvalidTokenAuthenticationException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public InvalidTokenAuthenticationException(final String msg) {
        super(msg);
    }

}
