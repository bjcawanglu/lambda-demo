package com.hmily.lambdademo.stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并行流
 */
public class StreamDemo5 {
    private static final Logger log = LoggerFactory.getLogger(StreamDemo5.class);
    public static void debug(int i) {
        log.info("debug: {}", i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        IntStream.range(1, 100).peek(StreamDemo5::debug).count();
//        调用 parallel 产生一个并行流
//        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

        // 并行流使用的线程池: ForkJoinPool.commonPool
        // 默认的线程数是 当前机器的cpu个数
        // 使用这个属性可以修改默认的线程数
//         System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//         IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

//        结论：多次调用 parallel、sequential，以最后一次调用为准
//        IntStream.range(1, 100)
////                先调用 parallel 产生并行流
//                .parallel().peek(StreamDemo5::debug)
////                 再调用 sequential 产生串行流
//                .sequential().peek(StreamDemo5::debug2)
//                .count();

        // 使用自己的线程池, 不使用默认线程池, 防止任务被阻塞
        // 线程名字 : ForkJoinPool-1
        ForkJoinPool pool = new ForkJoinPool(6);
        pool.submit(
                () -> IntStream.range(1, 100)
                        .parallel().peek(StreamDemo5::debug)
                        .count());
        pool.shutdown();
//        下面的代码是为了使上面的线程池能在 main方法运行起来
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug2(int i) {
        log.info("debug2: {}", i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
