package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DifferenceBetweenMapAndFlatMap {
    public static void main1(String[] args) {
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> stream1 = Arrays.stream(array);

        List<String[]> result = stream1
                .filter(x -> !x.equals("a"))      // x is a String[], not String!
                .collect(Collectors.toList());

        System.out.println(result.size());    // 0

        result.forEach(System.out::println);  // pr


        Stream<String[]> stream2 = Arrays.stream(array);
        List<String[]> result1 = stream2
                .filter(x -> {
                    for(String s : x){      // really?
                        if(s.equals("a")){
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());

        // print array
        result.forEach(x -> System.out.println(Arrays.toString(x)));

        String[][] array11 = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // Java 8
        String[] result11 = Stream.of(array11)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);    // [a, b, c, d, e, f]

        for (String s : result11) {
            System.out.println(s);
        }



    }

    public static void main(String[] args) {
        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/

        Set<String> collect =
                list.stream()
                      //  .map(x -> x.getBook())                              //  Stream<Set<String>>
                       // .flatMap(x -> x.stream())                           //  Stream<String>
                        .flatMap(x ->x.getBook().stream())
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);
    }
}
