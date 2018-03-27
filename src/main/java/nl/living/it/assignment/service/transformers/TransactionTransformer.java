package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.TransactionDto;
import nl.living.it.assignment.model.Transaction;
import org.springframework.stereotype.Component;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Component
public class TransactionTransformer implements ToDtoTransformer<TransactionDto, Transaction> {
    @Override
    public TransactionDto transform(final Transaction entity) {
        return TransactionDto.builder()
                .from(entity.getFrom().getId())
                .to(entity.getTo().getId())
                .money(entity.getMoney())
                .build();
    }
}
