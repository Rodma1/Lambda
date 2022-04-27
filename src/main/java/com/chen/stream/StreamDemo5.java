package com.chen.stream;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/27 22:25
 * @Version 1.0
 * @Description: 终结操作 : reduce 归并，reduce的作用是把stream中的元素给组合起来，
 * 我们可以传入一个初始值，它会按照我们的计算方式依次拿流中的元素和初始化值进行计算，计算结果再和后面的元素计算。
 */
public class StreamDemo5 {
    public static void main(String[] args) {
        List<Author> authors = new Datas().getAuthors();

        reduceTest(authors);
    }

    // 	reduce归并：对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
    private static void reduceTest(List<Author> authorList) {
        // 使用reduce求所有作者年龄的和
        Integer reduce = authorList.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result + element;
                    }
                });
        System.out.println(reduce);
    }

}
