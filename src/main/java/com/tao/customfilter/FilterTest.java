package com.tao.customfilter;

/**
 * @author: Penger
 * @time: 2019/8/27
 * @description: <p>
 * </p>
 **/
public class FilterTest {
    public static void main(String[] args) throws InterruptedException {
        LogFilter logFilter = new LogFilter();
        AuthFilter authFilter = new AuthFilter();
        Filter[] filters = new Filter[]{logFilter, authFilter};
        FilterChain chain = new FilterChain(filters);
        chain.doFilter(null, null);
    }
}
