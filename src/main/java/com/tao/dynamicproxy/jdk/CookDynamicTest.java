package com.tao.dynamicproxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
public class CookDynamicTest {
    @Test
    public void testDynamic() {
        Cook cook = new CookImpl();
        CookDynamicProxy cookDynamicProxy = new CookDynamicProxy(cook);
        Cook proxyInstance = (Cook) Proxy.newProxyInstance(cookDynamicProxy.getClass().getClassLoader(), cook.getClass().getInterfaces(), cookDynamicProxy);
        System.out.println(proxyInstance.getClass().getName());
        proxyInstance.dealwith("白菜萝卜");
        proxyInstance.cook("白菜萝卜人肉包子");

    }
}
