package com.j2eeconcept.immutable;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TestingImmutableClassConcept {
    public static void main(String[] args) {
        List<Person> sss =new ArrayList<>();
        Person p = new Person("nitin","gupta","nitin@sfds.com");
        sss.add(p);
        ImmutableClassConcept concept = new ImmutableClassConcept( 1l , new BigDecimal("100.897324892") , Instant.now() ,sss);
        concept.getAmount().add(new BigDecimal("10"));
        concept.getAmount().abs();
        Person p2 = new Person("nit33in","3333","nitin@333sfds.com");
        concept.getPersonList().add(p2);
        System.out.println(concept);
    }
}
