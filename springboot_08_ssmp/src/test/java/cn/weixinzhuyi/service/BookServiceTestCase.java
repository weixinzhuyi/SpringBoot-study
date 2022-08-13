package cn.weixinzhuyi.service;


import cn.weixinzhuyi.domain.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author weixinzhuyi
 * @create 2022-08-12-15:00
 */
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试21");
        book.setType("测试22");
        book.setDescription("测试23");
        bookService.save(book);
    }

    @Test
    void testGetByID() {
        Book book = bookService.getById(4);
        System.out.println(book);
    }
}
