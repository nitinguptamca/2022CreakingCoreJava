package com.hardQuestion.array;

import java.util.*;



public class Java8Sorting {

    public static void main(String[] args) {
        List<Person>  people = new ArrayList<>() ;
        people.add(new Person("gupta" ,"nitin","nitingauptamca@gmail.com"));
        people.stream().sorted(Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getEmail, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .forEach(System.out::println);
    }
}
