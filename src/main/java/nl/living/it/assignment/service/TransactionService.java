package nl.living.it.assignment.service;

import nl.living.it.assignment.dto.TransactionDto;
import nl.living.it.assignment.dto.TransactionListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.model.TransactionStatus;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface TransactionService {
    TransactionDto create(TransactionDto transaction) throws BusinessException;
    List<TransactionListDto> findByStatus(TransactionStatus status);
    void manage(Long id, TransactionStatus status) throws EntityNotFoundException;
}
