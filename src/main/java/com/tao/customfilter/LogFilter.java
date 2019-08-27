package com.tao.customfilter;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Request;

import javax.xml.ws.Response;

/**
 * @author: Penger
 * @time: 2019/8/27
 * @description: <p>
 * </p>
 **/
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) throws InterruptedException {
        Thread.sleep(5000);
        log.info("log filter");
    }
}
