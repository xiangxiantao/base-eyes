package com.xxt.stream.optional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalMap {

    static Stream<String> stream(){
        return Arrays.stream(new String[]{"a", "b", "c"});
    }

    /**
     * optional的map操作返回另一个optional，其中封装了function操作的返回值，当原optional为空时，不执行function，直接返回空
     * @param desc
     * @param function
     */
    static void test(String desc, Function<String, String> function){
        System.out.println("-----------"+ desc +"--------------");
        for (int i : IntStream.range(0,4).toArray()){
            System.out.println(stream().skip(i).findFirst().map(function));
        }
    }

    public static void main(String[] args) {
        test("后面补数字" , s -> s + 2);
    }

}
