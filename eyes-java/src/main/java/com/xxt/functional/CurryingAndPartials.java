package com.xxt.functional;

import java.util.function.Function;

/**
 * 柯里化函数就是将一个多参的函数分解为若干个单参函数的级联调用
 * 非柯里化函数：sum(1,2,3)
 * 柯里化函数：sum(1)(2)(3)
 * 优势：
 * 1.惰性计算，柯里化函数在没有执行最后一步之前，返回值都是函数，并没有进行实际的计算，在调用最后一层函数的时候，才会进行运算，起到延迟计算的作用
 * 2.动态生成函数：需求：求不同数的若干次幂
 *   按照传统的方法，我们需要
 */
public class CurryingAndPartials {
    // 未柯里化:
    static String uncurried(String a, String b) {
        return a + b;
    }

    static int mi(int n ,int m){
        int result = n;
        for (int i = 1; i < m; i++) {
            result *= n;
        }
        return result;
    }
    public static void main(String[] args) {
        // 柯里化的函数:
        Function<String, Function<String, String>> sum =
                a -> b -> a + b; // [1]

        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String>
                hi = sum.apply("Hi "); // [2]
        System.out.println(hi.apply("Ho"));

        // 部分应用:
        Function<String, String> sumHi =
                sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));

        System.out.println(mi(2,3));


        //利用柯里化函数求解m的n次方
        Function<Integer,Function<Integer, Integer>> power =
                m -> n -> {
                    Integer result = m;
                    for (int i = 1; i < n; i++) {
                        result *=m;
                    }
                    return result;
                };

        System.out.println(power.apply(3).apply(3));
    }
}