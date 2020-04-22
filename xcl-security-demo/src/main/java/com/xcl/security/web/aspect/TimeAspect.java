package com.xcl.security.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * TimeAspect
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.xcl.security.web.controller.UserConroller.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint  joinPoint) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arys is"+arg);
            
        }
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        System.out.println("time aspect 耗时"+(System.currentTimeMillis()-start));
        System.out.println("time aspect end");
        return proceed;
    }
}
