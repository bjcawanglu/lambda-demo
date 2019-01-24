package com.hmily.lambdademo;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int sub(int x, int y);
}

/**
 *  类型推断
 */
public class TypeDemo {

    public static void main(String[] args) {
//        变量类型定义
        IMath lambda = (x, y) -> x + y;

//        数组里
        IMath[] lambdas = {((x, y) -> x + y)};

//        强转
        Object lambda2 = (IMath)(x, y) -> x + y;

//        通过返回类型
        IMath lambda3 = createLambda();

//        常用这种方式，其实和 变量类型定义是一回事
        TypeDemo typeDemo = new TypeDemo();
//        typeDemo.test((x, y) -> x + y);
//        当有 二义性的时候，使用强转对应的接口来解决
        typeDemo.test((IMath) (x, y) -> x + y);
    }

    public static IMath createLambda(){
        return (x, y) -> x + y;
    }

    public void test(IMath math){

    }

    public void test(IMath2 math){

    }
}
