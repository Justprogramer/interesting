package com.tao.threadpool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * 自定义任务
 * </p>
 **/
@Slf4j
@Data
class CustomTask {
    private int taskId;

    CustomTask(int taskId) {
        this.taskId = taskId;
    }

    void taskRun() {
        log.info("custom task-{} running...", taskId);
    }
}
