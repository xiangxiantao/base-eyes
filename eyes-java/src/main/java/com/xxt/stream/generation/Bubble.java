package com.xxt.stream.generation;

import java.util.stream.Stream;

/**
 * 通过传递生成对象的lambda来创建包含相同对象的流
 */
public class Bubble {
    private final int i;

    private Bubble(int n){
        i = n;
    }

    private static int count = 0;

    public static Bubble build(){
        return new Bubble(count++);
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "i=" + i +
                '}';
    }

    public static void main(String[] args) {
        //由于 bubbler() 与 Supplier<Bubble> 是接口兼容的，我们可以将其方法引用直接传递给 Stream.generate()
        Stream.generate(Bubble::build)
                .limit(5)
                .forEach(System.out::println);
    }
}
