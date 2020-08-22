package com.xxt.stream.mid;

import com.xxt.stream.generation.FileToWordBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamMidOps {

    public static Stream<String> stream;

    static {
        try {
            stream = new FileToWordBuilder("/Users/haytt.xiang/Dev/base-eyes/eyes-java/src/main/resources/word.txt").stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //peek();
        //sort();
        //distinct();
        //map();
        //flatMap();
        //contact();
        fileToWordFlap();
    }

    /**
     * 利用peek无修改的查看元素
     * peek和foreach的区别：peek是一个中间操作，返回值仍然是流，可以继续往下进行操作；而foreach是终端操作，操作完成之后不能再继续使用流式操作
     * 该方法主要用于调试，查看流式操作中间过程之元素的情况
     */
    public static void peek(){
       stream.skip(21)
             .limit(4)
             .map(w -> w + " ")
             .peek(System.out::print)
             .map(String::toUpperCase)
             .peek(System.out::print)
             .map(String::toLowerCase)
             .forEach(System.out::print);
    }

    /**
     * sorted排序
     * Comparator.reverseOrder() 倒序
     */
    public static void sort(){
        stream.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    /**
     * 去重
     * 传统去重采用set集合进行，而直接采用stream的distinct方法工作量会较少很多
     */
    public static void distinct(){
        stream.distinct().forEach(System.out::println);
    }

    /**
     * 过滤，只保留Predicate方法返回true的元素
     */
    public static void filter(){
        stream.filter(s -> s.length() > 5).forEach(System.out::println);
    }

    /**
     * 应用函数到每一个元素，将函数返回值传递到输出流
     */
    public static void map(){
        stream.map(s -> s+"hahaaaaaaaaaa").forEach(System.out::println);
    }

    /**
     * 输入流中的每一个元素，通过一个函数产生一个流，再将每一个元素产生的流平铺到同一个输出流中
     */
    public static void flatMap(){
        Stream.of(1,2,3)
                .flatMap(i -> Stream.of("a" + i, "b" + i, "c" + i))
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 将两个流组合起来形成一个流
     */
    public static void contact(){
        Stream.concat(Stream.of("a", "b", "c"), Stream.of(1)).forEach(System.out::println);
    }

    /**
     * 让我们再看一下将文件划分为单词流的任务。我们最后使用到的是 FileToWordsRegexp.java，它的问题是需要将整个文件读入行列表中 —— 显然需要存储该列表。而我们真正想要的是创建一个不需要中间存储层的单词流。
     * 下面，我们再使用 flatMap() 来解决这个问题：
     * @throws IOException
     */
    public static void fileToWordFlap() throws IOException {
        Files.lines(Paths.get("/Users/haytt.xiang/Dev/base-eyes/eyes-java/src/main/resources/word.txt"))
                .skip(1)
                .flatMap(line -> Pattern.compile("[ ,.?]+")
                        .splitAsStream(line))
                .forEach(System.out::println);
    }

}
