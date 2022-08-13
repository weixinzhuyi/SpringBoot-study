package cn.weixinzhuyi.controller;

import cn.weixinzhuyi.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weixinzhuyi
 * @create 2022-08-09-15:25
 */

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private MyDataSource myDataSource;
    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");
        System.out.println(port);

        System.out.println(myDataSource);
        return "springboot is running...";

    }


}
