package com.chen.optional;

import com.chen.Author;
import com.chen.Datas;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/28 21:37
 * @Version 1.0
 * @Description: 安全值获取 :	如果我们期望安全的获取值。我们不推荐使用get方法，而是使用Optional提供的以下方法。
 */
public class OptionalDemo2 {
    public static void main(String[] args) {
//        List<Author> authors = new Datas().getAuthors();
        Author author = new Author();

        elseGetTest(author);

        elseThrowTest(null);

    }

    // orElseGet；获取数据并且设置数据为空时的默认值。如果数据不为空就能获取到该数据。
    // 如果为空则根据你传入的参数来创建对象作为默认值返回。
    private static void elseGetTest(Author author) {
        Optional<Author> author1 = Optional.ofNullable(author);
        Author author2 = author1.orElseGet(() -> new Author());
        System.out.println(author2.getName());

    }

    // orElseThrow:获取数据，如果数据不为空就能获取到该数据。如果为空则根据你传入的参数来创建异常抛出
    private static void elseThrowTest(Author author) {
        Optional<Author> author1 = Optional.ofNullable(author);
        try {
            Author author2 = author1.orElseThrow(new Supplier<Throwable>() {
                @Override
                public Throwable get() {
                    return new RuntimeException("author 为空");
                }
            });
            System.out.println(author2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
