package nl.living.it.assignment.auth.exception;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(final String message) {
        super(message);
    }

    public AuthenticationException(final String message, Throwable exception) {
        super(message, exception);
    }
}