package nl.living.it.assignment.auth.service;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.auth.exception.AuthenticationException;
import nl.living.it.assignment.auth.model.JwtUserDetails;
import nl.living.it.assignment.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author a.zenkovich
 * @since 23.03.18.
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(this.userRepository.findByUsername(username))
                .map(JwtUserDetails::new)
                .orElseThrow(() -> new AuthenticationException("User nor found."));
    }
}
