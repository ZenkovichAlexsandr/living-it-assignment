package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.TransactionListDto;
import nl.living.it.assignment.model.Transaction;
import org.springframework.stereotype.Component;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Component
public class TransactionListTransformer implements ToDtoTransformer<TransactionListDto, Transaction> {
    @Override
    public TransactionListDto transform(final Transaction entity) {
        return TransactionListDto.builder()
                .id(entity.getId())
                .to(entity.getTo().getName())
                .from(entity.getFrom().getName())
                .creationDate(entity.getCreationDate())
                .status(entity.getStatus())
                .build();
    }
}
