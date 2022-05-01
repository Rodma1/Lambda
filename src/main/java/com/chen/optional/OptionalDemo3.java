package com.chen.optional;

import com.chen.Author;
import com.chen.Book;
import com.chen.Datas;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author: 那就叫小智吧
 * @date: 2022/4/28 22:40
 * @Version 1.0
 * @Description: 过滤 | 判断
 */
public class OptionalDemo3 {
    public static void main(String[] args) {
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        new Datas().getAuthors();
        // 创建optional对象
        Optional<Author> author1 = Optional.ofNullable(author);

        filterTest(author1);
        presentTest(author1);
        mapTest();

    }

    // 过滤 ：我们可以使用filter方法对数据进行过滤。如果原本是有数据的，但是不符合判断，也会变成一个无数据的Optional对象。
    private static void filterTest(Optional<Author> author) {
        author.filter(author1 -> author1.getAge()>30)
                .ifPresent(author12 -> System.out.println(author12.getName()));
    }

//    判断 :我们可以使用isPresent方法进行是否存在数据的判断。如果为空返回值为false
//    ,如果不为空，返回值为true。但是这种方式并不能体现Optional的好处，**更推荐使用ifPresent方法**。
    private static void presentTest(Optional<Author> author) {

        if (author.isPresent()) {
            System.out.println("author 不为空");
        } else {
            System.out.println("author 为空");
        }
    }

    // 数据转换:Optional还提供了map可以让我们的对数据进行转换，并且转换得到的数据也还是被Optional包装好的，保证了我们的使用安全。
    private static void mapTest() {
        // 参数对象
        List<Author> authors = new Datas().getAuthors();
        // 创建optional对象
        Optional<List<Author>> authors1 = Optional.ofNullable(authors);
        // 我们想获取作家的书籍集合。
        Optional<List<Book>> books = authors1.map(authorList -> authorList.get(0).getBooks());
        books.ifPresent(books1 -> System.out.println(books1));

    }
}
