package com.itheima.web.controller;

import java.io.Serializable;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 15:48
 * @Package: com.itheima.web.controller
 * @ClassName: Result
 * @Description: TODO
 * @Version: 2021/9/25
 */
public class Result implements Serializable {
    private String message;
    private Object data;
    private boolean flag;
    private Integer code;

    public Result(String message, Object data) {
        this.message = message;
        this.data = data;
        this.code = Code.SUCCESS;
        this.flag = true;
    }

    public Result(String message, Object data, boolean flag, Integer code) {
        this.message = message;
        this.data = data;
        this.flag = flag;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
