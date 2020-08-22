package com.xxt.stream.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream的findAny(),findFirst(),max(),min(),reduce()等方法将返回一个Optinal
 */
public class OptionalOps {

    public static void createOptional() {
        Optional<String> first = Stream.<String>empty().findFirst();
        System.out.println(first);

        /**
         * 当你接收到 Optional 对象时，应首先调用 isPresent() 检查其中是否包含元素。如果存在，可使用 get() 获取。
         */
        if (first.isPresent()){
            String s = first.get();
        }

        /**
         * ifPresent(Consumer)：当值存在时调用 Consumer，否则什么也不做。
         * orElse(otherObject)：如果值存在则直接返回，否则生成 otherObject。
         * orElseGet(Supplier)：如果值存在则直接返回，否则使用 Supplier 函数生成一个可替代对象。
         * orElseThrow(Supplier)：如果值存在直接返回，否则使用 Supplier 函数生成一个异常。
         */
        System.out.println(first.orElse("xxxxxxx"));

        /**
         * 当optional对象不为空时直接执行下一步操作
         */
        first.ifPresent(s -> System.out.println(s));


        /**
         * 创建Optinal对象
         * empty()：生成一个空 Optional。
         * of(value)：将一个非空值包装到 Optional 里。
         * ofNullable(value)：针对一个可能为空的值，为空时自动生成 Optional.empty，否则将值包装在 Optional 中。
         */
        Optional.empty();
        Optional.of("sss");
        Optional.ofNullable("ssssss");

    }


}
