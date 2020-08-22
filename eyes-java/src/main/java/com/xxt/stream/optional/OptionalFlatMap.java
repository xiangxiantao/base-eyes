package com.xxt.stream.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalFlatMap {

    static Stream<String> stream(){
        return Arrays.stream(new String[]{"a", "b", "c"});
    }

    /**
     * 同 map()，flatMap() 将提取非空 Optional 的内容并将其应用在映射函数。
     * 唯一的区别就是 flatMap() 不会把结果包装在 Optional 中，因为映射函数已经被包装过了。
     * 我们已经在每一个映射函数中显式地完成了包装，但是很显然 Optional.flatMap() 是为那些自己已经生成 Optional 的函数而设计的。
     * @param desc
     * @param function
     */
    static void test(String desc, Function<String, Optional<String>> function){
        System.out.println("-----------"+ desc +"--------------");
        for (int i : IntStream.range(0,4).toArray()){
            System.out.println(stream().skip(i).findFirst().flatMap(function));
        }
    }

    public static void main(String[] args) {
        test("后面补数字" , s -> Optional.of(s + 2));
    }
}
