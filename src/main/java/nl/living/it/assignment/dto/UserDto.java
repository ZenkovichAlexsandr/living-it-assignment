package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Dto {
    private Long id;
    private String fullName;
}
