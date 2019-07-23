package com.tao.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * 线程池测试
 * </p>
 **/
public class ThreadPoolTest {
    @Test
    public void test() throws InterruptedException {
        CustomThreadPool pool = new CustomThreadPool(10, new LinkedBlockingQueue<>());
        for (int i = 0; i < 20; i++) {
            CustomTask task = new CustomTask(i);
            pool.execute(task);
        }
        Thread.sleep(20000);
        pool.shutdown();
    }
}
