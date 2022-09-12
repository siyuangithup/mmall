package com.mmall.gateway.exception;

import com.mmall.gateway.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 统一异常类
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 23:38
 */
@RestControllerAdvice
//ControllerAdvice 用于拦截异常
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {

        log.error("default exception->", e);

        return ServerResponse.createByErrorMsg("系统异常");

    }

    @ExceptionHandler(MmallException.class)
    public Object handlerException(MmallException e) {

        log.error("MmallException exception->", e);

        return ServerResponse.createByError(e.getCode(),e.getMessage());

    }


}
