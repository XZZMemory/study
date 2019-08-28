package com.memory.study.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by memory
 * on 2019/8/27 17 38
 */
@Aspect
@Component
/*这两个注解，哪个都可以  @Aspect 、 @Component*/
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    static {
        logger.info("切面初始化");
    }

    /*第一个* 返回值的任意类型*/
    @Before("execution(* com.memory.study.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        StringBuilder sb = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null) {
                sb.append("arg:" + arg.toString() + "|");
            }
        }
        logger.info("before method:" + method + "参数：" + sb);
    }

    @After("execution(* com.memory.study.controller.*Controller.*(..))")
    public void afterMethod() {
        logger.info("after method   " + new Date());
    }
}
