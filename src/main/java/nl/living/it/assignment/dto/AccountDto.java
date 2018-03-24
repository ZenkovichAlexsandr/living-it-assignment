package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Dto {
    @NotEmpty(message = "account.name.not-empty")
    private String name;
    private double money;
    private Set<Long> users = new HashSet<>();
}
