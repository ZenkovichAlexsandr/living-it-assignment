package nl.living.it.assignment.repository;

import nl.living.it.assignment.model.Transaction;
import nl.living.it.assignment.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByStatusAndFromUsers_Id(TransactionStatus status, Long userId);
    Transaction findByIdAndFromUsers_Id(Long id, Long userId);
    List<Transaction> findAllByFromIdOrToId(Long fromId, Long toId);
}
