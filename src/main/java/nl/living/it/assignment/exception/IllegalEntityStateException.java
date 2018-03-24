package nl.living.it.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public class IllegalEntityStateException extends BusinessException {

    public IllegalEntityStateException(String message) {
        super(message);
    }

    public IllegalEntityStateException(String message, IOException exception) {
        super(message, exception);
    }

    public IllegalEntityStateException(final String message, final List<Object> params) {
        super(message, params);
    }

    public IllegalEntityStateException(final String message, final List<Object> params, final Throwable cause) {
        super(message, params, cause);
    }

    public IllegalEntityStateException(final String message, final List<Object> params,
                                       final Set<FieldError> fieldErrors) {
        super(message, params, fieldErrors);
    }

    @Override
    public String getErrorCode() {
        return "ILLEGAL_STATE_EXCEPTION";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

