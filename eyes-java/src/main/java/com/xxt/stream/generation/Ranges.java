package com.xxt.stream.generation;

import java.util.stream.IntStream;

public class Ranges {

    public static void main(String[] args) {
        tranditionalFor();
        rangeFor();
        sum(5);
    }

    /**
     * 传统for循环
     */
    public static void tranditionalFor(){
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result+=i;
        }
        System.out.println(result);
    }

    /**
     * IntStream range()方法的for循环
     */
    public static void rangeFor(){
        int result = 0;
        for (int i : IntStream.range(0,10).toArray()){
            result+= i ;
        }
        System.out.println(result);
    }

    /**
     * IntStream range()实现累加
     * @param i
     */
    public static void sum(int i){
        System.out.println(IntStream.range(0, i).sum());
    }

}
