package com.tao.queue;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Penger
 * time ： 2019/3/21
 * <p>
 * ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
 * LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
 * PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
 * DelayQueue：一个使用优先级队列实现的无界阻塞队列。
 * SynchronousQueue：一个不存储元素的阻塞队列。
 * LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
 * LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
 * </p>
 */
public class DelayQueueDemo {
    private static DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

    /**
     * 初始化消费者线程
     */
    private static void initConsumer() {
        Runnable task = () -> {
            while (true) {
                try {
                    System.out.println("尝试获取延迟队列中的任务。" + LocalDateTime.now());
                    System.out.println(delayQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        Thread consumer = new Thread(task);
        consumer.start();
    }

    public static void main(String[] args) {
        initConsumer();
        try {
            // 等待消费者初始化完毕
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delayQueue.add(new DelayTask(1000, "Task1"));
        delayQueue.add(new DelayTask(2000, "Task2"));
        delayQueue.add(new DelayTask(3000, "Task3"));
        delayQueue.add(new DelayTask(4000, "Task4"));
        delayQueue.add(new DelayTask(5000, "Task5"));
    }
}

@Data
class DelayTask implements Delayed {
    /**
     * 延迟时间
     */
    private long delay;
    /**
     * 到期时间
     */
    private long expire;
    /**
     * 数据
     */
    private String msg;
    /**
     * 创建时间
     */
    private long now;

    public DelayTask(long delay, String msg) {
        this.delay = delay;
        this.msg = msg;
        this.expire = System.nanoTime() + delay;
        this.now = System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.nanoTime(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // compare zero ONLY if same object
        if (o == this) {
            return 0;
        }
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));

    }
}