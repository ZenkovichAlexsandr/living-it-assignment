package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto implements Dto {
    private double money;
    @NotNull(message = "transaction.from.required")
    private Long from;
    @NotNull(message = "transaction.to.required")
    private Long to;
}
