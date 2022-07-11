package com.chen.stream;

import com.chen.Author;
import com.chen.Datas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/24 23:58
 * @Version 1.0
 * @Description: 中间操作
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        List<Author> authors = new Datas().getAuthors();

        filterTest(authors);

        mapTest(authors);

        distinctTest(authors);

        sortedTest(authors);

        limitTest(authors);

        skipTest(authors);

        flatMapTest(authors);

    }

    // filter:对元素进行条件过滤
    private static void filterTest(List<Author> authorList) {
        authorList.stream().filter(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge()>20;
            }
        }).forEach(System.out::println);
    }

    // map:可以把对流中的元素进行计算或转化
    private  static void mapTest(List<Author> authorList) {
        // 打印所有作家的名字
        authorList.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(System.out::println);
    }

    // distinct 可以去除流中的重复元素
    private static void distinctTest(List<Author> authorList) {
        authorList.stream()
                .distinct()
                .forEach(System.out::println);
    }

    // sorted 可以对流中的元素进行排序
    private static void sortedTest(List<Author> authorList) {
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
        authorList.stream()
                .distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o1.getAge()-o2.getAge();
                    }
                })
                .forEach(author -> System.out.println(author.getAge()));
    }

    // limit 可以设置流的最大长度，超出的部分将被抛弃
    private static void limitTest(List<Author> authorList) {
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
        authorList.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge()- o2.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    // skip 跳过流中的前n个元素，返回剩下的元素
    private static void skipTest(List<Author> authorList) {
        // 打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
        authorList.stream()
                .distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o2.getAge()- o1.getAge();
                    }
                })
                .skip(1)
                .forEach(author -> System.out.println(author.getAge()));
    }

    // flatMap 	map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
    private static void flatMapTest(List<Author> authorList) {
        // 打印所有书籍的名字。要求对重复的元素进行去重。
        authorList.stream()
                .flatMap(new Function<Author, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .forEach(new Consumer<Object>() {
                    @Override
                    public void accept(Object author) {
                        System.out.println(author);
                    }
                });
    }


}
