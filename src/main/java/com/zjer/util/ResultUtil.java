package com.zjer.util;

/**
 * @author shijun
 * @date 2018/8/1 23:10
 * @param 
 * @return 
 */
public class ResultUtil<T> {
    private Integer state;
    private String msg;
    private T data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
