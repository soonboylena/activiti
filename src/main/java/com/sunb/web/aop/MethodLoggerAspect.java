package com.sunb.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by sunb on 17-4-22.
 */

@Aspect
@Component
public class MethodLoggerAspect {

    private static Logger logger = LoggerFactory.getLogger(MethodLoggerAspect.class);

    @Pointcut("execution(public * com.sunb.web..*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void methodStart(JoinPoint joinPoint) {
        logger.info("require: {}.{} args={}"
                , joinPoint.getSignature().getDeclaringTypeName()
                , joinPoint.getSignature().getName()
                , joinPoint.getArgs()
        );

    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfter(Object object) {
        logger.info("return value : {}", String.valueOf(object));
    }
}
