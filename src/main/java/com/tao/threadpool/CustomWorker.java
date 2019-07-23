package com.tao.threadpool;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * 自定义工作线程,优先执行直接赋予的任务，执行完毕之后再从队列获取任务
 * </p>
 **/
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class CustomWorker extends Thread {
    private CustomTask task;
    private final BlockingQueue<CustomTask> taskQueue;
    private Boolean running;

    CustomWorker(String name, CustomTask task, BlockingQueue<CustomTask> taskQueue, Boolean running) {
        super(name);
        this.task = task;
        this.taskQueue = taskQueue;
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            if (task != null) {
                task.taskRun();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                task = taskQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("queue has [{}] elements", taskQueue.size());
        }
    }

    void interruptSelf() {
        this.interrupt();
    }
}
