package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UserListDto implements Dto {
    private Long id;
    private String fullName;
}



