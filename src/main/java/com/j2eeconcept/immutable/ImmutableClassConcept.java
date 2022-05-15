package com.j2eeconcept.immutable;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

/**
 * <ol>
 *     <li>Avoid providing any methods which modify object state. Obvious candidates are property setters as well as any other methods adjusting existing properties.</li>
 *     <li>Make all fields private – to avoid modifying them directly, especially if they are reference variables.</li>
 *     <li>Make all fields final – to explicitly express intent that their values should not change. This also means all the properties need to be assigned at the moment of creation in constructor.</li>
 *     <li>Ensure class cannot be extended – this eliminates a possibility to expose its variables indirectly through a child class. It can be accomplished by making the class final or by providing a private constructor. Static factory method or a builder class is used to instantiate objects in such a scenario.</li>
 *     <li>Ensure no outside class can modify mutable reference variables. Imagine your class has a list property. Even though final, the contents of the list can be easily modified. Final refers to the fact that the variable cannot be assigned any other list instance, but it ignores the fact that list contents need to stay untouched. In order to ensure immutability, no external class can initialize such a variable or retrieve a reference to it. It is usually accomplished with defensive copying such property.</li>
 *     <li>Return a defensive, immutable copy.
 *      <br>
 *      public Set getLineItems() {<br>
 *     return Collections.unmodifiableSet(lineItems);<br>
 * }
 * </li>
 * </ol>
 */

public class ImmutableClassConcept {
    private final Long id;
    private final BigDecimal amount;
    private final Instant timestamp;
    private final List<Person> personList;

    public ImmutableClassConcept(Long id, BigDecimal amount, Instant timestamp ,List<Person> personList) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.personList= Collections.unmodifiableList(personList);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ImmutableClassConcept{" +
                "id=" + id +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", personList=" + personList +
                '}';
    }
}
