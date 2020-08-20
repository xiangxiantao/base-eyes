package com.xxt.functional.methods;

/**
 * 不绑定对象的非静态方法引用方式
 */
public class UnboundMethodReference {
    public static void main(String[] args) {

        //因为MakeString函数式接口的方法没有X入参，所以不能直接不指明对象就利用方法引用
        //MakeString ms = X::f; // [1]

        //TransformX接口的方法因为有X入参，可以使用未指明对象的X的方法引用
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x,"xxx")); // [2]
        System.out.println(x.f("xxx")); // 同等效果
    }
}

class X {
    String f(String s) { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x, String s);
}
