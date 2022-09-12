package com.mmall.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * 打印请求和响应日志
 * Description
 * Create by dong.zhou
 * Date 2022/9/13 01:00
 */
//切面
//@Aspect
//暴露给spring
//@Component
@Slf4j
public class WebLogAspect {
//
//    //拦截点
//    @Pointcut("execution(public * com.mmall.gateway.controller.*.*(..))")
//    public void webLog() {
//
//    }
//
//
//
//
//    /**
//     * 打印请求信息
//     *
//     * @param joinPoint
//     */
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) {
//        //收到请求 记录请求内容
//        //分析并打印请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//
//        HttpServletRequest request = attributes.getRequest();
//
//        log.info("url" + request.getRequestURL().toString());
//
//        log.info("HTTP_METHOD" + request.getMethod());
//
//        log.info("ip" + request.getRemoteAddr());
//
//        //获取类的信息
//        log.info("class_method" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//
//        log.info("args" + Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//    /**
//     * 返回信息
//     *
//     * @param res
//     */
//    @AfterReturning(returning = "res", pointcut = "webLog()")
//    public void doAfterReturning(Object res) throws JsonProcessingException {
//        //处理完请求 响应内容
//        log.info("RESPONSE" + new ObjectMapper().writeValueAsString(res));
//    }
}
