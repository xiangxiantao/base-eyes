package com.xxt.stream.generation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToWordBuilder {

    Stream.Builder<String> builder  = Stream.builder();

    public FileToWordBuilder(String FilePath) throws IOException {
        Files.lines(Paths.get(FilePath))
                .skip(1)
                .forEach(line -> {
                    for (String w : line.split("[ ,.?]+")){
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        new FileToWordBuilder("/Users/haytt.xiang/Dev/base-eyes/eyes-java/src/main/resources/word.txt").stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }

}
