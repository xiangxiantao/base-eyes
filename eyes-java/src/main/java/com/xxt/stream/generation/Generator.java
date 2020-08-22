package com.xxt.stream.generation;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream.generate搭配Supplier方法
 */
public class Generator implements Supplier<String> {

    public static int current = 0;
    Random random = new Random(23);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        //return letters[random.nextInt(letters.length)] + "";
        return current<letters.length ? letters[current++] + "" : "*";
    }

    /**
     * 通过Supplier的get方法来生成流中的元素
     * @param args
     */
    public static void main(String[] args) {
        Generator generator = new Generator();
        Repeat.repeat(5,()->{
            String word1 = Stream.generate(generator)
                    .limit(10)
                    .collect(Collectors.joining("|"));

            System.out.println(word1);
        });

    }
}
