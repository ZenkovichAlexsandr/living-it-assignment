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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
@Table(name = "TRANSACTIONS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "transactions")
public class Transaction extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne(optional = false)
    private Account from;

    @ManyToOne(optional = false)
    private Account to;

    @Column
    private LocalDateTime approvalDate;
}
