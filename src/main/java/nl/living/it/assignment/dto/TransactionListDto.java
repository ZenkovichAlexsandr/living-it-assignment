package nl.living.it.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionListDto implements Dto {
    private Long id;
    private LocalDateTime creationDate;
    private String from;
    private String to;
}
