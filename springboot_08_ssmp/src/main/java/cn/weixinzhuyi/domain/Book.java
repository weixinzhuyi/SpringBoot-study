package cn.weixinzhuyi.domain;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;

/**
 * @author weixinzhuyi
 * @create 2022-08-12-11:18
 */
@Data
public class Book  {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
