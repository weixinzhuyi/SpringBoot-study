package cn.weixinzhuyi.controller.utils;

import lombok.Data;

/**
 * @author weixinzhuyi
 * @create 2022-08-13-11:50
 * @description 返回前端数据专用工具类
 */
@Data
public class R {
    private boolean flag;
    private Object data;

    private String message;

    public R() {
    }

    public R(boolean flag) {
        this.flag = flag;
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(String message){

        this.message = message;
    }
}
