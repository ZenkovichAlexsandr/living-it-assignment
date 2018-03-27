package nl.living.it.assignment.repository;

import nl.living.it.assignment.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUsersId(Long userId);
    Account findByUsers(Long userId);
}
