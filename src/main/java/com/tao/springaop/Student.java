package com.tao.springaop;

import org.springframework.stereotype.Component;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
@Component
public class Student implements Person {
    @MyAspect
    @Override
    public void name(String name) {
        System.out.println("my name is " + name);
    }
}
