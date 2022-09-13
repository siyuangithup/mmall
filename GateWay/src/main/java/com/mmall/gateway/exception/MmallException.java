package com.mmall.gateway.exception;

import lombok.Getter;

/**
 * 统一异常
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 23:46
 */
@Getter
public class MmallException extends IllegalArgumentException {
    private final Integer code;
    private final String message;

    public MmallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MmallException(MmallExceptionEnum mmallExceptionEnum) {
        this.code = mmallExceptionEnum.getCode();
        this.message = mmallExceptionEnum.getMessage();
    }


}
