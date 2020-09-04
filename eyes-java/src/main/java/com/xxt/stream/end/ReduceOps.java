package com.xxt.stream.end;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceOps {

    public static void main(String[] args) {
        //reduce1();
        //reduce2();
        //reduce3();
        //reduce4();
        reduce5();
    }

    public static void reduce1(){
        System.out.println(Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}).reduce((integer, integer2) -> integer + integer2).orElse(0));
    }

    public static void reduce2(){
        System.out.println(Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}).reduce(100, (integer, integer2) -> integer + integer2));
    }

    public static void reduce4(){
        String[] strings = {"1", "2", "3", "4", "5", "6", "7"};
        StringBuilder stringBuilder = new StringBuilder(Arrays.stream(strings).findFirst().orElse(null));
        System.out.println(Stream.of(strings).reduce((s1, s2) -> String.join(",", s1, s2)).orElse(""));
    }

    public static void reduce5(){
        String[] strings = {"1", "2", "3", "4", "5", "6", "7"};
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(strings).forEach(s -> stringBuilder.append(s).append(","));
        System.out.println(stringBuilder.toString());
    }

    public static void reduce3(){
        ArrayList<Integer> list = new ArrayList<>();
        Stream.of(new Integer[]{1,2,3,4,5,6,7})
                .reduce(list,
                        (acc, item)->{
                            acc.add(item);
                            return acc;
                        },
                        (acc,item)->null);
        list.forEach(System.out::println);
    }

}
