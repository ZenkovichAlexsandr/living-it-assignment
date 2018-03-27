package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsDto implements Dto {
    private String name;
    private List<UserDto> users = new ArrayList<>();
    private List<TransactionListDto> transactions = new ArrayList<>();
}
