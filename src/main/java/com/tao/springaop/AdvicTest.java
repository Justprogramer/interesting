package com.tao.springaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
@Aspect
@Component
public class AdvicTest {
    @Pointcut(value = "@annotation(MyAspect)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void pointcutBefore() {
        System.out.println("在pointcut()执行前执行 before");
    }

    @After("pointcut()")
    public void pointcutAfter() {
        System.out.println("在pointcut()执行后执行 after");
    }
}
