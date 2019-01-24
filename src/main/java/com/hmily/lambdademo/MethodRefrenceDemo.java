package com.hmily.lambdademo;

import java.util.function.*;

public class MethodRefrenceDemo {

    public static void test1(){
        Consumer<String> consumer = i -> System.out.println(i);

//        方法引用
        Consumer<String> consumer2 = System.out::println;

        consumer.accept("input data 1");
        consumer.accept("input data 2");
    }

    public static void test2(){
//        静态方法的 方法引用
        Consumer<Dog> consumer = Dog::brak;
        Dog dog = new Dog();
        consumer.accept(dog);
    }

    public static void test3(){
//        成员方法的方法引用
        Dog dog = new Dog();
//        Function<Integer, Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
//        System.out.println("还剩下 " + function.apply(2) + " 斤");

        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下 " + function.applyAsInt(2) + " 斤");

        dog.eat(1);

        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下 " + eatFunction.apply(dog, 1) + " 斤");

//        无参构造函数的 方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());

//        带参数的构造方法的 方法引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象：" + function2.apply("大黄 "));
    }


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }


}

class Dog{
    private String name = "哮天犬";
    public static void brak(Dog dog){
        System.out.println(dog + " 叫了");
    }

    private int food = 10;
    public int eat(Dog this, int num){
        System.out.println("吃了 " + num +  " 斤狗粮");
        this.food -= num;
        return this.food;
    }

    public Dog(){

    }
    public Dog(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
