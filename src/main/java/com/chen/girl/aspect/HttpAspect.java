package com.chen.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.chen.girl.controller.GirlController.*(..))")
    public void log(){

    }

//    @Before("execution(public * com.chen.girl.controller.GirlController.getGirl(..))")
    @Before("log()")
    public void daBefore(JoinPoint joinPoint){
        logger.info("开始切面");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        //url
        logger.info("url:{}",httpServletRequest.getRequestURI());

        //method
        logger.info("method:{}",httpServletRequest.getMethod());
        //ip
        logger.info("ip:{}",httpServletRequest.getRemoteAddr());
        //类方法
        logger.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args:{}",joinPoint.getArgs());


    }

    @After("log()")
    public void doAfter(){
        logger.info("byebye...");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response:{}"+object.toString());
    }
}
