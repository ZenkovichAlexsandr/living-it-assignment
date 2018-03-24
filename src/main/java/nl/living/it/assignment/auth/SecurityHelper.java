package nl.living.it.assignment.auth;

import nl.living.it.assignment.auth.exception.AuthenticationException;
import nl.living.it.assignment.auth.model.JwtUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
public class SecurityHelper {

    public static Authentication getAuthenticationWithCheck() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final boolean checkAuthenticationExists = Objects.nonNull(authentication) && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return authentication;
        }

        throw new AuthenticationException("Authentication failed.");
    }

    public static Long getCurrentUserId() {
        final JwtUserDetails authentication = (JwtUserDetails) SecurityHelper
                .getAuthenticationWithCheck().getPrincipal();
        return authentication.getId();
    }
}
