package com.hmily.lambdademo.lambda;

@FunctionalInterface
interface Interface1{
    int doubleNum(int i);
}

@FunctionalInterface
interface Interface2{
    int doubleNum(int i);
    default int add(int x, int y){
        return x + y;
    }
}

@FunctionalInterface
interface Interface3{
    int doubleNum(int i);
    default int add(int x, int y){
        return x * y;
    }
}

@FunctionalInterface
interface Interface4 extends Interface2, Interface3 {
    @Override
    default int add(int x, int y) {
        return 0;
    }
}

public class LambdaDemo1 {
    public static void main(String[] args) {
        method2();
    }

    public static void method2() {
        Interface2 i2 = i -> i * 2;
        System.out.println(i2.doubleNum(10));
        System.out.println(i2.add(3, 4));
    }

    public static void method1() {
        Interface1 i1 = (i) -> i * 2;

        Interface1 i2 = i -> i * 2; // 最常见的写法

        Interface1 i3 = (int i) -> i * 2;

        Interface1 i4 = (i) -> {
            System.out.println("--------");
            return i * 2;
        };
    }
}
