package com.zhaobo.stream.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AopTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/8 - 下午3:17
 * </p>
 */
@Aspect
@Component
public class AopTest {

    @Pointcut("execution(* com.zhaobo.stream.transaction.*.*(..))")
    public void pointCut() {
    }

    /*@Before("pointCut()")
    public void doAccessCheck() {
        System.out.println("AOP前置通知。。。。");
    }

    @After("pointCut()")
    public void afterProcess() {
        System.err.println("AOP后置处理。。。。");
    }

    @AfterReturning("pointCut()")
    public void afterReturing() {
        System.err.println("returning ....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.err.println("throwing....");
    }*/

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {

        try {
            System.out.println("代理方法执行前");
            joinPoint.proceed();
            System.out.println("代理方法执行后");
        } catch (Throwable throwable) {
            System.out.println("代理方法执行异常");
            throwable.printStackTrace();
        }

    }


}
