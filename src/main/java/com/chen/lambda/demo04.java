package com.chen.lambda;

import java.util.function.Function;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/1 0:15
 * @Description: 将String类型的数字转化 为Int类型
 */
public class demo04 {

    public static void main(String[] args) {

        before();

        after();

    }
    // lambda之前
    private static void before() {
        // 转为Integer类型
        Integer result = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        System.out.println(result);
    }

    // lambda之后
    private static void after() {
        Integer result = typeConver(ss -> Integer.valueOf(ss));
        System.out.println(result);
    }
    public static <R> R typeConver(Function<String,R> function) {
        String ss = "123";

        return function.apply(ss);
    }
}
