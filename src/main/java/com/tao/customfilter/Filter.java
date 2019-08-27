package com.tao.customfilter;

import org.omg.CORBA.Request;

import javax.xml.ws.Response;

/**
 * @author: Penger
 * @time: 2019/8/27
 * @description: <p>
 * </p>
 **/
public interface Filter {
    /**
     * 自定义过滤器
     *
     * @param request  模拟httpServletRequest
     * @param response 模拟httpServletResponse
     * @param chain    过滤器链，用于回调
     */
    void doFilter(Request request, Response response, FilterChain chain) throws InterruptedException;
}
