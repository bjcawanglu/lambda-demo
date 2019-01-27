package com.hmily.lambdademo.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Stream 运行机制
 * 1. 所有操作是链式调用, 一个元素只迭代一次
 * 2.  每一个中间操作返回一个新的流. 流里面有一个属性 sourceStage ， 指向同一个 地方,就是Head
 * 3. Head -> nextStage -> nextStage -> ...  ->  null
 * 4. 有状态操作会把无状态操作阶段,单独处理
 */
public class RunStream {
    private static final Logger log = LoggerFactory.getLogger(RunStream.class);
    public static void main(String[] args) {
        Random random = new Random();
//        随机产生数据
        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
//        产生 10 个 ( 无限流需要短路操作. )
                .limit(10)
//        第1个无状态操作
                .peek(s -> print("peek " + s))
//        第2个无状态操作
                .filter(s -> {
                    print("filter " + s);
                    return s > 1000000;
                })
                .sorted((i1, i2) -> {
                    print("排序: " + i1 + ", " + i2);
                    return i1.compareTo(i2);
                })
                .peek(s -> print("peek2 " + s))
                .parallel();
//        终止操作
        stream.count();
    }

    /**
     * 打印日志并sleep 5 毫秒
     * @param s
     */
    public static void print(String s) {
        // System.out.println(s);
        // 带线程名(测试并行情况)
        log.info( "s: {}", s);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {

        }
    }
}
