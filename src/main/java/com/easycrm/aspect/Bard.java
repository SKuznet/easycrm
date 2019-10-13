package com.easycrm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {

//    @Pointcut("execution(* com.easycrm.service.impl.KnightServiceImpl.getAchievement(..))")
//    public void serviceBefore(){
//    }
//
//    @Before("serviceBefore()")
//    public void getSong(JoinPoint joinPoint){
//        System.err.println("Lalalalaaa");
//    }

    @Around("execution(* com.easycrm.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        // method run
        Object obj = joinPoint.proceed();

        long timeAfter = System.currentTimeMillis();
        System.err.println("Lalalalaaa");
        System.err.println("Knight fight with " + val + ". It spent " + (timeAfter - timeBefore) / 1000 + " seconds...");
        return obj;
    }
}
