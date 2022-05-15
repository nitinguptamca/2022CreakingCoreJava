package com.j2eeconcept.hibernateImmutable;/*
package concept.clear.prectise.hibernateImmutable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

*/
/**
 * <p> Hibernate introduced its proprietary @Immutable annotation. Proprietary – meaning it’s not part of JPA standard. When @Immutable is present on an entity class, no update statements are executed against an entity when Persistence Context is flushed. In other words, a database record created with @Immutable entity, will never be updated.</p>
 *//*

@Entity
@Table(name = "FINANCIAL_TRANSACTION")
@org.hibernate.annotations.Immutable
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private Instant timestamp;

    FinancialTransaction() {
    }

    FinancialTransaction(BigDecimal amount, Instant timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public static FinancialTransaction newInstance(BigDecimal amount, Instant timestamp) {
        return new FinancialTransaction(amount, timestamp);
    }

    //getters
}
*/
