package com.chen.optional;

import com.chen.Author;
import com.chen.Datas;

import java.util.Optional;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/28 22:40
 * @Version 1.0
 * @Description: 过滤：我们可以使用filter方法对数据进行过滤。
 * 如果原本是有数据的，但是不符合判断，也会变成一个无数据的Optional对象。
 */
public class OptionalDemo3 {
    public static void main(String[] args) {

        Author author = new Author();
        presentTest(null);


    }

    // 过滤 ：我们可以使用filter方法对数据进行过滤。如果原本是有数据的，但是不符合判断，也会变成一个无数据的Optional对象。
    private static void filterTest() {

    }

    private static void presentTest(Author author) {
        Optional<Author> author1 = Optional.ofNullable(author);
        if (author1.isPresent()) {
            System.out.println("author 不为空");
        } else {
            System.out.println("author 为空");
        }
    }
}
