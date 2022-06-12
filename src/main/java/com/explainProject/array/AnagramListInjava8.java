package com.explainProject.array;

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Determine if a list composed of anagram elements in Java 8
//"cat", "cta", "act", "atc", "tac", "tca"
public class AnagramListInjava8 {
    public static void main(String[] args) {

        String findOutFirstRepeatingChar= "my name is Nitin kumar gupta";

        Character name = Optional.of('a')
                .orElseGet(() -> 'b');

        Character sss = findOutFirstRepeatingChar.chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .findFirst().map(entry -> entry.getKey()).
                orElseGet(()->'*');

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }



    public static void main1(String[] args) {
        String[] strArr = {"cat", "cta", "act", "atc", "tac", "tca"};
        boolean count = Arrays.stream(strArr)
                .map(String::toCharArray)
                .map(arr -> {
                    Arrays.sort(arr);
                    return arr;
                })
                .map(String::valueOf)
                .distinct()
                .count() == 1;
        System.out.println(count);
    }


    boolean isAnagram(String[] list) {
        boolean solution1 = Stream.of(list) // Stream<String>
                .map(String::toCharArray) // Stream<char[]>
                .peek(Arrays::sort) // sort
                .map(String::valueOf) // Stream<String>
                .distinct() //distinct
                .count() == 1;

        boolean anagrams = Stream.of(list)
                .map(String::chars)
                .map(IntStream::sorted)
                .map(IntStream::toArray)
                .map(Arrays::toString)
                .distinct().count() == 1;

        boolean sss = Stream.of(list)
                .map(s -> IntBuffer.wrap(s.chars().sorted().toArray()))
                .distinct().count() == 1;



        return true;
    }
}
