package com.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingJava8Char {
    public static void main(String[] args) {
        String str="my name is nitin Kumar Gupta";
        str.chars().mapToObj(c -> Character.valueOf((char)c)).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toUnmodifiableList());

    }
}
