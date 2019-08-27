package com.tao.customfilter;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Request;

import javax.xml.ws.Response;

/**
 * @author: Penger
 * @time: 2019/8/27
 * @description: <p>
 * 过滤器采用责任链模式，通过filterChain调用各个filter,基于java回调实现
 * </p>
 **/
@Slf4j
public class FilterChain {
    private Filter[] filters;
    /**
     * 调用的filter索引
     */
    private int index;

    public FilterChain(Filter[] filters) {
        this.filters = filters;
        this.index = 0;
    }

    public void doFilter(Request request, Response response) throws InterruptedException {
        if (filters.length <= 0) {
            return;
        }
        while (index <= filters.length - 1) {
            log.info("filter chain {} begin", index + 1);
            filters[index++].doFilter(request, response, this);
        }
    }
}
