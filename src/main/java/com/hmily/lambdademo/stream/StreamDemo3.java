package com.hmily.lambdademo.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 *  Stream 的中间操作
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        String str = "my name is hmily";
//        打印长度超过 2 的 单词的长度
        Stream.of(str.split(" "))
                .filter(s -> s.length() > 2)
                .map(s -> s.length())
                .forEach(System.out::println);

        System.out.println("--------------flatMap------------");
//        flatMap A->B属性(是个集合), 最终得到所有的A元素里面的所有B属性集合
//                A : "my name is hmily"
//                B: A 里面的每个字母的 ascii
//        intStream/longStream 并不是Stream的子类, 所以要进行装箱 boxed
        Stream.of(str.split(" "))
                .flatMap(s -> s.chars().boxed())
                .forEach(i -> System.out.println((char) i.intValue()));

        System.out.println("--------------peek------------");
//        peek 用于debug. 是个中间操作,和 forEach 是终止操作
        Stream.of(str.split(" "))
                .peek(System.out::println)
                .forEach(System.out::println);

        System.out.println("--------------limit------------");
//        limit： 主要用于做无限流的短路条件
        new Random().ints()
                .filter(i -> i > 100 && i < 1000)
                .limit(5)
                .forEach(System.out::println);
    }
}
