package com.xxt.stream.generation;

import java.util.stream.IntStream;

/**
 * 通过rang封装 for(int i :n )循环操作
 */
public class Repeat {
    public static void repeat(int n , Runnable action){
        IntStream.range(0,n).forEach(i ->action.run());
    }
}
