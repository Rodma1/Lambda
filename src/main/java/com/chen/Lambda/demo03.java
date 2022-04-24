package com.chen.Lambda;

import java.util.function.IntPredicate;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/1 0:02
 * @Description: 找到能被2整除的数
 */
public class demo03 {

    public static void main(String[] args) {

        before();

        after();

    }
    // lambda表达式之前
    private static void before() {
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%2==0;
            }
        });
    }

    // lambda之后
    private static void after() {
        printNum(value -> value%2==0);
    }
    // 循环输出
    public static void printNum(IntPredicate predicate) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for (int i : arr) {
            // 如果能被2整除就输出
            if (predicate.test(i)){
                System.out.println(i);
            }
        }
    }

}
