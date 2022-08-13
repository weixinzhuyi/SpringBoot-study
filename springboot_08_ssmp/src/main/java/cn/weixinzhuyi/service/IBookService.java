package cn.weixinzhuyi.service;

import cn.weixinzhuyi.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weixinzhuyi
 * @create 2022-08-12-14:53
 */

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int pages, int pageSize, Book book);
}
