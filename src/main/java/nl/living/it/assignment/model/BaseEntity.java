package nl.living.it.assignment.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author a.zenkovich
 * @since 11.03.18.
 */
@MappedSuperclass
public abstract class BaseEntity implements BaseIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Override
    public long getId() {
        return id;
    }
}
