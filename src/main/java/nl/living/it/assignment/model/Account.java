package nl.living.it.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author a.zenkovich
 * @since 11.03.18.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "accounts")
public class Account extends BaseEntity {
    public static final String JOIN_COLUMN = "ACCOUNT_ID";

    @Column(nullable = false)
    private String name;
}
