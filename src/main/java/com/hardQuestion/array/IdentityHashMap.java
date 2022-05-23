package com.hardQuestion.array;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdentityHashMap {
    public static void main(String[] args) {
        String name = "my name is nitin kumar gupta";
        //find first  repeating character

        String sss="abc";
       int sssss= System.identityHashCode(sss);

        Character firstValue = name
                .chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).findFirst()
                .map(e -> e.getKey()).orElseGet(null);
        System.out.println(firstValue);

        }
}
