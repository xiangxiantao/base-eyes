package com.xxt.stream.end;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ReduceOps {

    public static void main(String[] args) {
        //reduce1();
        //reduce2();
        reduce3();
    }

    public static void reduce1(){
        System.out.println(Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}).reduce((integer, integer2) -> integer + integer2).orElse(0));
    }

    public static void reduce2(){
        System.out.println(Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}).reduce(100, (integer, integer2) -> integer + integer2));
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
