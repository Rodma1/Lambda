package com.chen.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/20 0:19
 * @Version 1.0
 * @Description: 创建流
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        List<Author> datas = new Datas().getAuthors();

        demo02();

        demo03();
    }

    // 单例集合 集合对象.stream()
    private static void demo01( List<Author> authorList) {
        // 转化成流
        authorList.stream()
                .distinct()
                .filter(author -> author.getAge()<18)
                .forEach(author -> System.out.println(author.getName()));
    }
    // 数组 Arrays.stream(数组) 或者使用Stream.of来创建
    private static void demo02() {
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(arr);
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.print(num);
            }
        });

        // 通过stream.of
        Stream.of(arr).forEach(System.out::print);
    }

    // 双列集合 : 转换成单例集合后在创建
    private static void demo03() {
        Map<String, Integer>  map = new HashMap<>();
        map.put("小陈",12);
        map.put("小黄",19);
        map.put("小豆",31);
        Stream<Map.Entry<String, Integer>> entries = map.entrySet().stream();
        entries.filter(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                return stringIntegerEntry.getValue()>19;
            }
        }).forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> stringIntegerEntry) {
                System.out.println(stringIntegerEntry);
            }
        });
    }


}
