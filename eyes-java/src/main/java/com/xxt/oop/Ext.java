package com.xxt.oop;

/**
 * @description: com.xxt.oop
 * @author: haytt.xiang
 * @date: 2020-09-09 19:14
 **/
public class Ext extends Base {

    public String job;

    public static void main(String[] args) {
        String a = "eelve";
        String b = "eelve";
        String c = new String("eelve");

        System.out.println(a == b);//true

        System.out.println(a.equals(b));//true

        System.out.println(a == c);//false

        System.out.println(a.equals(c));//true

        String d = c.intern();//jdk8字符串常量池在堆内存中,jdk8之前在运行时常量池，属于永久代管理


        System.out.println(a == d);//true

        System.out.println(a.equals(d));//true

        System.out.println(c == d);//false

        System.out.println(c.equals(d));//true
    }

}
