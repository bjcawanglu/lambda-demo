package com.hmily.lambdademo.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 *  什么是函数式编程
 */
public class WhyUseLambda {

    private static final Logger log = LoggerFactory.getLogger(WhyUseLambda.class);

    public static void main(String[] args) {
        int[] nums = {22, 44, -30, 90, -400, 10};
        old(nums);
        lambda(nums);
        threadContrast();
    }
//    命令式编程
    public static void old(int[] nums){
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        log.info("old method min: {}", min);
    }
//    函数式
    public static void lambda(int[] nums){
        int min = IntStream.of(nums).min().getAsInt();
//        int min = IntStream.of(nums).parallel().min().getAsInt();
        log.info("lambda method min: {}", min);
    }

    public static void threadContrast(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info(" old method ok");
            }
        }).start();

        new Thread(() -> log.info("lambda method ok")).start();
    }

    public static void threadContrast1(){
        Runnable target = new Runnable() {
            @Override
            public void run() {
                log.info(" old method ok");
            }
        };
        new Thread(target).start();

        Runnable target2 = () -> log.info("lambda method ok");
        new Thread(target2).start();
    }

    public static void threadContrast2(){
        Object target = new Runnable() {
            @Override
            public void run() {
                log.info(" old method ok");
            }
        };
        new Thread((Runnable)target).start();

        Object target2 = (Runnable) () -> log.info("lambda method ok");
        new Thread((Runnable)target2).start();
    }
}
