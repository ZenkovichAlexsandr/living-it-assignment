package nl.living.it.assignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDto implements Dto {
    private String token;

    public LoginResponseDto(final String token) {
        this.token = token;
    }
}
