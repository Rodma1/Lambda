package com.chen.lambda;

import java.util.function.IntConsumer;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/1 0:31
 * @Description: IntConsumer是一个接口，先使用匿名内部类的写法调用该方法
 * 目的 :循环输出数组的值
 */
public class demo05 {

    public static void main(String[] args) {

        before();

        after();

    }

    // lambda之前
    private static void before() {
        forArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }

    // lambda表达式
    private static void after() {
        forArr(value -> System.out.println(value));
    }
    // 循环
    private static void forArr(IntConsumer intConsumer) {
        int[]  arr = {1,2,3,4};

        for (int i : arr) {
            intConsumer.accept(i);
        }
    }
}
