package com.xxt.stream.generation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 利用正则表达式将字符串转为stream
 */
public class FileToWordRegexp {

    private String all;

    public FileToWordRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath)).skip(1).collect(Collectors.joining(" "));
    }

    public Stream<String> stream(){
        return Pattern.compile("[ ,.?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        FileToWordRegexp fileToWordRegexp = new FileToWordRegexp("/Users/haytt.xiang/Dev/base-eyes/eyes-java/src/main/resources/word.txt");
        fileToWordRegexp.stream().limit(7).map(w -> w + " ").forEach(System.out::print);
    }

}
