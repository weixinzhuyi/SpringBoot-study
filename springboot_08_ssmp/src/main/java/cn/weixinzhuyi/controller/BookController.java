package cn.weixinzhuyi.controller;

import cn.weixinzhuyi.controller.utils.R;
import cn.weixinzhuyi.domain.Book;
import cn.weixinzhuyi.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weixinzhuyi
 * @create 2022-08-13-10:54
 */

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());

    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(true, bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {

        return new R(true, bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {

        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果页码值过大，修改为最大页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(null != page, page);
    }
}


