package com.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class WordsCountProgram {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("D:\\1Workspace\\2022CreakingCoreJava\\src\\main\\java\\com\\java8\\FlatMapExample2.java");
        Stream<String> streamString = Files.lines(path);
        Stream<String[]> linesss = streamString.flatMap(line -> line.lines().map(ll -> ll.trim().split(" ")));
        List<String> ssss = linesss.flatMap(Stream::of).collect(Collectors.toUnmodifiableList());
        Map<String, Long> mapCount = ssss.stream().map(word -> word.replaceAll("[^a-zA-z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> wordCount3 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "")
                        .toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()));

        List<String> ssssss = Files.readAllLines(path);
        ssssss.stream().flatMap( line -> line.lines().map(ll -> ll.strip().split(" "))).flatMap(Stream::of).collect(Collectors.toUnmodifiableList())
                .stream().map(word -> word.replaceAll("[^a-zA-Z]","").toLowerCase().strip());
        }
}
