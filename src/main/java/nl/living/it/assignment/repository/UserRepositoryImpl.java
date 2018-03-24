package nl.living.it.assignment.repository;

import nl.living.it.assignment.dto.UserListDto;
import nl.living.it.assignment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserListDto> lookup() {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<UserListDto> criteriaQuery = cb.createQuery(UserListDto.class);
        final Root<User> from = criteriaQuery.from(User.class);

        final Expression<String> fullName = cb.concat(
                cb.concat(
                        from.get("firstName"),
                        " "
                ),
                from.get("lastName")
        );

        criteriaQuery.multiselect(
                from.get("id"),
                fullName
        );

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
