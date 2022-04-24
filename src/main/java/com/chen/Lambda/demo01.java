package com.chen.Lambda;

/**
 * @author: 那就叫小智吧
 * @date: 2022/3/31 23:28
 * @Description: lambda函数式编程
 */
public class demo01 {
    public static void main(String[] args) {

        before();

        after();

    }

    private static void before() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动一个线程");
            }
        }).start();
    }

    private static void after() {
        new Thread(() -> System.out.println("lambda 启动一个线程")).start();
    }
}
