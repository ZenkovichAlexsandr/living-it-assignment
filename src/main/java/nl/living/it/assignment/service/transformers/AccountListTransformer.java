package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.AccountListDto;
import nl.living.it.assignment.model.Account;
import org.springframework.stereotype.Component;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Component
public class AccountListTransformer implements ToDtoTransformer<AccountListDto, Account> {
    @Override
    public AccountListDto transform(final Account entity) {
        return AccountListDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .money(entity.getMoney())
                .build();
    }
}
