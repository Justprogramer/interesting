package com.tao.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * 自定义线程池简单实现：
 * 1. 线程池大小
 * 2. 创建、销毁线程池
 * 3. 工作线程
 * 4. 任务队列
 * </p>
 **/
@Slf4j
class CustomThreadPool {
    /**
     * 状态，是否在运行
     */
    private volatile Boolean running = true;
    /**
     * 任务缓存队列
     */
    private final BlockingQueue<CustomTask> taskQueue;
    /**
     * worker的执行需要thread
     */
    private Vector<CustomWorker> workers = new Vector<>();
    /**
     * 最大线程数
     */
    private int maxPoolSize;
    /**
     * 当前线程数
     */
    private int workSize;

    CustomThreadPool(int maxPoolSize, BlockingQueue<CustomTask> taskQueue) {
        this.maxPoolSize = maxPoolSize;
        this.workSize = 0;
        this.taskQueue = taskQueue;
    }

    void execute(CustomTask task) {
        Optional.ofNullable(task).orElseThrow(NullPointerException::new);
        if (workSize < maxPoolSize) {
            addThread(task);
        } else if (!taskQueue.offer(task)) {
            rejectTask(task);
        }
    }

    /**
     * 添加线程执行start
     *
     * @param task task
     */
    private void addThread(CustomTask task) {
        //当前线程数+1
        workSize++;
        //创建新的Worker
        CustomWorker worker = new CustomWorker("Thread-" + workSize, task, taskQueue, running);
        workers.add(worker);
        //执行thread
        worker.start();
    }

    /**
     * 停止所有线程
     */
    void shutdown() {
        running = false;
        if (!workers.isEmpty()) {
            for (CustomWorker worker : workers) {
//                worker.setRunning(false);
                worker.interruptSelf();
            }
        }
        Thread.currentThread().interrupt();
    }

    private void rejectTask(CustomTask task) {
        log.info("blocking queue has no space, reject task{}", task.getTaskId());
    }
}
