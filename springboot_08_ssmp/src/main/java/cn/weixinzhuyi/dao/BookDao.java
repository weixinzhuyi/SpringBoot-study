package cn.weixinzhuyi.dao;

import cn.weixinzhuyi.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author weixinzhuyi
 * @create 2022-08-12-11:25
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
//    @Select("select * from tbl_book where id = #{id}")
//    Book getById(Integer id);
}
