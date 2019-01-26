package com.hmily.lambdademo.lambda;

import java.util.function.*;

interface IMoneyFormat{
    String format(int i);
}
class MyMoney{
    private final int money;
    public MyMoney(int money){
        this.money = money;
    }

    public void printMoney(IMoneyFormat moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.format(this.money));
    }
}

class MyMoney2{
    private final int money;
    public MyMoney2(int money){
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.apply(this.money));
    }
}

public class MyMoneyDemo {
    public static void main(String[] args) {
//        MyMoney me = new MyMoney(100000);
//        me.printMoney(i -> new DecimalFormat("#,###").format(i));

//        MyMoney2 me = new MyMoney2(100000);
//        me.printMoney(i -> new DecimalFormat("#,###").format(i));

//        MyMoney2 me = new MyMoney2(100000);
//        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
////        函数接口链式操作
//        me.printMoney(moneyFormat.andThen(s -> "RMB " + s));

        fuctionTest();
    }


    public static void fuctionTest(){
//        断言函数接口
        Predicate<Integer> predicate = i -> i > 0;
        System.out.println(predicate.test(-1));
//        消费函数接口
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("input data");
    }

    public static void fuctionTest2(){
//        断言函数接口
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(-1));
//        消费函数接口
        IntConsumer consumer = s -> System.out.println(s);
        consumer.accept(99);
    }
}
