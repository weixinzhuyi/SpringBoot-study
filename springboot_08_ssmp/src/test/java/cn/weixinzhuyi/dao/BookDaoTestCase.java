package cn.weixinzhuyi.dao;

import cn.weixinzhuyi.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author weixinzhuyi
 * @create 2022-08-12-11:27
 */

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }


    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));


    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDescription("测试数据1");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setType("测试数据123");
        book.setName("测试数据1");
        book.setDescription("测试数据1");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(2);

    }


    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
    }


    @Test
    void testGetBy(){
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Book::getName,"测试");

        bookDao.selectList(lqw);

    }
}
