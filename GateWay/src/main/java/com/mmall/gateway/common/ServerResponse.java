package com.mmall.gateway.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 高可用
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 18:31
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//返回值中 如果存在null的数据 则不显示
public class ServerResponse<T> implements Serializable {

    //状态码
    private final int status;

    //返回文言
    private String msg;

    //对象
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    //不显示在返回的json信息中
    //todo 尝试一下 不加注解返回什么
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ServerResponse<T> createBySuccess() {

        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());

    }

    public static <T> ServerResponse<T> createBySuccessMsg(String msg) {

        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);

    }

    public static <T> ServerResponse<T> createBySuccess(T data) {

        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);

    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {

        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);

    }

    public static <T> ServerResponse<T> createByError() {

        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());

    }

    public static <T> ServerResponse<T> createByErrorMsg(String msg) {

        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), msg);

    }


    public static <T> ServerResponse<T> createByError(int status, String msg) {

        return new ServerResponse<T>(status, msg);

    }

}
