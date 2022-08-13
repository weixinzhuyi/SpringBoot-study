package cn.weixinzhuyi.service.impl;

import cn.weixinzhuyi.dao.BookDao;
import cn.weixinzhuyi.domain.Book;

import cn.weixinzhuyi.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author weixinzhuyi
 * @create 2022-08-12-14:57
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements IBookService {
   @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage,int pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,lqw);
        return page;
    }
//    @Autowired
//    private BookDao bookDao;
//    @Override
//    public Boolean save(Book book) {
//        return bookDao.insert(book) > 0;
//    }
//
//    @Override
//    public Boolean update(Book book) {
//        return bookDao.updateById(book) > 0;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return bookDao.deleteById(id) > 0;
//    }
//
//    @Override
//    public Book getById(Integer id) {
//        return bookDao.selectById(id);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
}
