package com.chen.optional;

import com.chen.Author;
import com.chen.Datas;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/27 23:19
 * @Version 1.0
 * @Description: 创建对象
 */
public class OptionalDemo1 {
    public static void main(String[] args) {
        List<Author> authors = new Datas().getAuthors();
        optionalCreate(authors);

        presentTest(authors);

    }

    // 创建对象 : 避免空指针异常
    private static void optionalCreate(List<Author> authorList) {
        Optional<List<Author>> authorList1 = Optional.ofNullable(authorList);
        System.out.println(authorList1.get());
//        System.out.println(22);
    }

    // 安全消费值 ifPresent
    private static void presentTest(List<Author> authorList) {
        Optional<List<Author>> authorList1 = Optional.ofNullable(authorList);

        authorList1.ifPresent(new Consumer<List<Author>>() {
            @Override
            public void accept(List<Author> authorList) {
                System.out.println(authorList.get(0).getName());
            }
        });
    }

}
