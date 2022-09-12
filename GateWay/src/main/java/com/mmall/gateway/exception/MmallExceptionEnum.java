package com.mmall.gateway.exception;

import lombok.Getter;

/**
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 23:46
 */
@Getter
public enum MmallExceptionEnum {
    USERNAME_PASSWORD_INPUT_NOT_NULL(1,"用户名或密码不可以为空"),
    USERNAME_PASSWORD_INPUT_ERROR(2,"用户名或密码不正确"),
    ;
    private final int code;

    private final String message;

    MmallExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
