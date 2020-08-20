package com.xxt.functional.lambda;

/**
 * 利用函数式编程递归计算n的阶乘
 */
public class RecursiveFactorial {

    public IntCall fact;

    public static void main(String[] args) {

        RecursiveFactorial recursiveFactorial = new RecursiveFactorial();
        //书中示例，一行代码完成递归
        recursiveFactorial.fact= n -> n==0 ? 1 : n * recursiveFactorial.fact.call(n-1);

        //利用匿名内部类实现与上述表达相同的效果
        //fact = new IntCall() {
        //    @Override
        //    public int call(int n) {
        //        return n == 0 ? 1 : call(n-1);
        //    }
        //};

        System.out.println(recursiveFactorial.fact.call(5));
    }

}
