package com.hmily.lambdademo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 流的创建
 */
public class StreamDemo2 {
    public static void main(String[] args) {
//        从集合创建
        ArrayList<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream(); // 并行流

//        从数组创建
        Arrays.stream(new int[]{1, 2, 3});

        //        创建数字流
        IntStream.of(1, 2, 3);
        IntStream.rangeClosed(1, 5); // 创建从 1  到 5 的数字流

//        使用 random 创建一个无限流，注意无限流要给个短路值，否则会一直创建下去
        new Random().ints().limit(5);

//        自己产生流
        Random random = new Random();
        Stream.generate(() -> random.nextInt()).limit(5);
    }
}
