package com.xxt.stream.generation;

import java.util.stream.Stream;

/**
 * 通过iterate进行斐波那契数列计算
 */
public class Fibonacci {

    //iterate只记录结果,利用x记录上一个数
    int x= 1;

    Stream<Integer> numbers(){
        return Stream.iterate(0, i->{
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(5) //跳过前5个
                .limit(10)  //取十个
                .forEach(System.out::println);
    }

}
