package nl.living.it.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public class BusinessException extends RuntimeException {
    private final List<Object> params;
    private final Collection<FieldError> fieldErrors;

    public BusinessException(String message) {
        super(message);
        params = new ArrayList<>();
        fieldErrors = new HashSet<>();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        params = new ArrayList<>();
        fieldErrors = new HashSet<>();
    }

    public BusinessException(String message, List<Object> params) {
        this(message);
        this.params.addAll(params);
    }

    public BusinessException(String message, List<Object> params, Throwable cause) {
        this(message, cause);
        this.params.addAll(params);
    }

    public BusinessException(final String message, final List<Object> params,
                             final Collection<FieldError> fieldErrors) {
        super(message);
        this.params = params;
        this.fieldErrors = fieldErrors;
    }

    /**
     * Error code that describes the exception.
     *
     * @return code of the error.
     */
    public String getErrorCode() {
        return "UNEXPECTED";
    }

    /**
     * Http status associated with the exception.
     *
     * @return http status of the error.
     */
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Params the describe the error cause.
     *
     * @return key-value map of getParams.
     */
    public List<Object> getParams() {
        return params;
    }

    /**
     * Params the describe the error cause in array.
     *
     * @return ordered array of values of getParams
     */
    public Object[] getParamsAsArray() {
        if (getParams() != null) {
            return getParams().toArray();
        }
        return new Object[0];
    }

    /**
     * List of fields that should be highlighted
     * @return the list of fields
     */
    public Collection<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
