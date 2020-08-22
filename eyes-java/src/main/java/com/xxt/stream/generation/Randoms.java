package com.xxt.stream.generation;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 获取5-20之间7个有序不重复的随机数
 */
public class Randoms {

    public static void main(String[] args) {
        //setPrint();
        streamPrint();
    }

    /**
     * 利用流式操作
     * 可读性好，语义明确
     */
    public static void streamPrint(){
        new Random(47)
                .ints(5,20)
                .distinct()
                .limit(9)
                .sorted()
                .forEach(System.out::println);

        System.out.println(IntStream.range(1, 5).sum());
    }

    /**
     * 利用sortedSet
     */
    public static void setPrint(){
        Random random =new Random(47);
        SortedSet<Integer> sortedSet = new TreeSet();
        while (sortedSet.size()<7){
            int nextInt = random.nextInt(20);
            if (nextInt<5) continue;
            sortedSet.add(nextInt);
        }
        System.out.println(sortedSet);
    }
}
