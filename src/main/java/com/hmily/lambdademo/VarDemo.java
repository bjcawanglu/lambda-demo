package com.hmily.lambdademo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 */
public class VarDemo {
    public static void main(String[] args) {
//        final String str = "hello world";
////        str = "ddd";
//        Consumer<String> consumer = s -> System.out.println(s + str);
//        consumer.accept("lambda ");

        List<String> list = new ArrayList<>();
        Consumer<String> consumer = s -> System.out.println(s + list);
        consumer.accept("lambda ");
    }
}
