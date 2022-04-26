package com.chen.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/25 22:17
 * @Version 1.0
 * @Description: 终结操作
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        List<Author> authors = new Datas().getAuthors();
        forEachTest(authors);

        countTest(authors);

        maxTest(authors);

        collectTest(authors);

    }

    // forEach 对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。
    private static void forEachTest(List<Author> authorList) {
        // 对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。
        authorList.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });
    }

    // count 可以用来获取当前流中元素的个数
    private static void countTest(List<Author> authorList) {
        //        打印这些作家的所出书籍的数目，注意删除重复元素。
        long count = authorList.stream()
                .flatMap(new Function<Author, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .count();
        System.out.println(count);
    }

    // max&min 可以用来做流中的最值
    private static void maxTest(List<Author> authorList) {
        // 获取这些作家的所出书籍的最高分
        Optional<Integer> max = authorList.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer score1, Integer score2) {
                        return score1 - score2;
                    }
                });
        System.out.println(max.get());
    }

    // collect 把当前流转换成一个集合
    private static void collectTest(List<Author> authorList) {
        // 获取一个存放所有作者名字的List集合。
        List<String> collect = authorList.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        //        获取一个所有书名的Set集合。
        Set<Book> collect1 = authorList.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(collect1);

        // 获取一个Map集合，map的key为作者名，value为List<Book>
        Map<String, List<Book>> collect2 = authorList.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        System.out.println(collect2);
    }

}
