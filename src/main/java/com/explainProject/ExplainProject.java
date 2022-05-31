package com.explainProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExplainProject {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\book\\data.txt");
        Stream<String> streamString = Files.lines(path);
        String lineSeperate = streamString.collect(Collectors.joining(System.lineSeparator()));

     /*  HashMap<String, GfcidData> data = Arrays.stream(input).parallel()
                .map(lines -> lines.split(Pattern.quote("~")))
                .map(e -> new GfcidData(e))
                .filter(e -> !e.gfcid.isBlank())
                .collect(HashMap<String, GfcidData>::new,
                        (m, c) -> m.put(c.getGfcid(), c),
                        (m, u) -> {
                        });*/
    }
}
