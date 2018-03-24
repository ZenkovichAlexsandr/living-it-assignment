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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "USERS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "users")
public class User extends BaseEntity {
    public static final String JOIN_COLUMN = "USER_ID";
    public static final String USER_ACCOUNT_JOIN_TABLE = "USER_ACCOUNT";

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = User.USER_ACCOUNT_JOIN_TABLE,
            joinColumns = @JoinColumn(name = User.JOIN_COLUMN),
            inverseJoinColumns = @JoinColumn(name = Account.JOIN_COLUMN))
    private Set<Account> accounts = new HashSet<>();
}
