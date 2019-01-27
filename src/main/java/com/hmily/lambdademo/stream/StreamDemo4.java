package com.hmily.lambdademo.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  终止操作
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        String str = "my name is hmily";
//        使用并行流
        str.chars().parallel().forEach(i -> System.out.print((char) i));
        System.out.println();
        System.out.println("--forEachOrdered--");
//        使用 forEachOrdered 保证顺序
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
        System.out.println();
//        收集到 list
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

//        使用 reduce 拼接字符串
        System.out.println();
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse("")); // 如果 letters 为 null， 则打印空字符串出来
//        带初始化值的 reduce
        System.out.println();
        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);
//        计算所有单词的总长度
        System.out.println();
        Integer length = Stream.of(str.split(" "))
                .map(s -> s.length())
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);
        System.out.println();

        // max 的使用
        Optional<String> max = Stream.of(str.split(" "))
                .max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());

        // 使用 findFirst 短路操作
        OptionalInt findFirst = new Random().ints().findFirst();
        System.out.println(findFirst.getAsInt());
    }
}
