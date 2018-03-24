package nl.living.it.assignment.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message, Object id) {
        super(message, Collections.singletonList(id));
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "ENTITY_NOT_FOUND";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
