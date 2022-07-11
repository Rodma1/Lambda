package com.chen.lambda;

import java.util.function.IntBinaryOperator;

/**
 * @author: 那就叫小智吧
 * @date: 2022/3/31 23:35
 * @Description: 写一个 a+b 两个参数相加等于多少
 */
public class demo02 {

    public static void main(String[] args) {
        before();

        after();
    }

    // lambda之前
    private static void before() {
        // 通过匿名内部类的写法调用applyAsInt方法
        int i = Add(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        System.out.println(i);
    }

    // lambda之后
    private static void after() {
        int i = Add((left, right) -> left + right);
        System.out.println(i);
    }

    private static int Add(IntBinaryOperator operator) {
        int a =10;
        int b =20;
        return operator.applyAsInt(a,b);
    }




}
