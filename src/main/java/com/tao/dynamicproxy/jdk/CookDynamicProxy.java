package com.tao.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
public class CookDynamicProxy implements InvocationHandler {
    private Object realCookHandler;

    public CookDynamicProxy(Object realCookHandler) {
        this.realCookHandler = realCookHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        System.out.println("代理方法名" + method.getName());
        method.invoke(realCookHandler, args);
        System.out.println("代理结束");
        return null;
    }
}
