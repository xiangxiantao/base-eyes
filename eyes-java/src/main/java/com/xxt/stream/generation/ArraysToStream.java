package com.xxt.stream.generation;

import java.util.Arrays;

/**
 * Arrays转为Stream
 */

public class ArraysToStream {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1,2,3,4,5}).forEach(System.out::print);
    }
}
