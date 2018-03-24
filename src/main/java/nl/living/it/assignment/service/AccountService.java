package nl.living.it.assignment.service;

import nl.living.it.assignment.dto.AccountDto;
import nl.living.it.assignment.dto.AccountListDto;
import nl.living.it.assignment.exception.BusinessException;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface AccountService {
    List<AccountListDto> findAll();
    AccountDto create(AccountDto account) throws BusinessException;

}
