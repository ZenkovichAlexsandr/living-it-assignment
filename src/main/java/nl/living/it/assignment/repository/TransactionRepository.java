package nl.living.it.assignment.repository;

import nl.living.it.assignment.model.Transaction;
import nl.living.it.assignment.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStatusAndFromUsers(TransactionStatus status, Long userId);
    Transaction findByIdAndFromUsers(Long id, Long userId);
}
