package com.chen.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/26 23:04
 * @Version 1.0
 * @Description: 总结操作二 ： 查找与匹配
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        final List<Author> authors = new Datas().getAuthors();

        anyMatchTest(authors);

        allMatchTest(authors);

        noneMatchTest(authors);

        findAnyTest(authors);

        findFirstTest(authors);
    }

    // anyMatch 可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。
    private static void anyMatchTest(List<Author> authorList) {
        //        判断是否有年龄在29以上的作家
        boolean b = authorList.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);

    }

    // allMatch 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。
    private static void allMatchTest(List<Author> authorList) {
        // 	判断是否所有的作家都是成年人
        boolean b = authorList.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(b);
    }

    // noneMatch  可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false
    private static void noneMatchTest(List<Author> authorList) {
        // 判断作家是否都没有超过100岁的。
        boolean b = authorList.stream()
                .noneMatch(author -> author.getAge() >= 100);

        System.out.println(b);
    }

    // findAny 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
    private static void findAnyTest(List<Author> authorList) {
        //	获取任意一个年龄大于18的作家，如果存在就输出他的名字
        Optional<Author> any = authorList.stream()
                .filter(author -> author.getAge() > 18)
                .distinct()
                .findAny();

        System.out.println(any.get());
    }

    // findFirst 获取流中的第一个元素
    private static void findFirstTest(List<Author> authorList) {
        // 获取一个年龄最小的作家，并输出他的姓名。
        Optional<Author> first = authorList.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        System.out.println(first.get().getName());

    }


}
