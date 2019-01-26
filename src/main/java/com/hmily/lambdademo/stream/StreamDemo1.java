package com.hmily.lambdademo.stream;

import java.util.stream.IntStream;

/**
 *  Stream 流的概念
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        外部迭代器
        int sum1 = 0;
        for (int i : nums) {
            sum1 += i;
        }
        System.out.println("sum1 = " + sum1);
//        内部迭代器
        int sum2 = IntStream.of(nums).sum();
        System.out.println("sum2 = " + sum2);

//        惰性求值就是终止操作没有调用的情况下，中间操作不会执行
//        map 就是中间操作（返回 stream 的操作）
//        sum 就是终止操作
        int sum3 = IntStream.of(nums).map(i -> i * 2).sum();
        System.out.println("sum3 = " + sum3);

        int sum4 = IntStream.of(nums).map(StreamDemo1:: doubleNum).sum();
        System.out.println("sum4 = " + sum4);

        IntStream.of(nums).map(StreamDemo1:: doubleNum);
    }

    public static int doubleNum(int i){
        System.out.println(i + " * 2 ");
        return i * 2;
    }
}
