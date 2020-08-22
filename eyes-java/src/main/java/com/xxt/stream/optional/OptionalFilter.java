package com.xxt.stream.optional;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalFilter {

    static Stream<String> stream(){
        return Arrays.stream(new String[]{"a", "b", "c"});
    }

    static void test(String desc, Predicate<String> pred){
        System.out.println("-----------"+ desc +"--------------");
        for (int i : IntStream.range(0,4).toArray()){
            System.out.println(stream().skip(i).findFirst().filter(pred));
        }
    }

    public static void main(String[] args) {
        test("全是true", s-> true);
        test("全是false", s-> false);
    }

}
