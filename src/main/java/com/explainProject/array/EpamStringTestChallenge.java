package com.explainProject.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * find out elements ,who have length is less than 5 characters
 * and print in upper case insertion order must be preserved  .
 * redundant element must not print.
 */
public class EpamStringTestChallenge {
    public static void main(String[] args) {
        String str ="New York City NYC, often simply called New York is the most populous city in the United States";
        List<String> keys = Arrays
                .stream(str.replaceAll("[@!#$,]", "").split(Pattern.quote(" ")))
                .map(ch -> ch.toUpperCase())
                .filter(el -> el.length() < 5)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(e -> e.getKey()).collect(Collectors.toUnmodifiableList());
        System.out.println(keys );
    }



}
