package com.tao.algorithm;

import lombok.Data;

/**
 * 循环输出 0 1 a 2 3 b ..... 50 51 z
 * <p>
 * author: TAOPENG
 * time ： 2019/3/12
 **/
public class ThreadNotification {
    @Data
    private class Tag {
        private Boolean tag = false;
    }

    private final Tag tag = new Tag();

    class DemoOne implements Runnable {
        int i = 0;

        @Override
        public void run() {
            while (i < 52) {
                synchronized (tag) {
                    while (tag.getTag()) {
                        try {
                            tag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(" " + i + " " + (i + 1));
                    i = i + 2;
                    tag.setTag(true);
                    tag.notify();
                }
            }

        }
    }

    class DemoTwo implements Runnable {
        char c = 'a';

        @Override
        public void run() {
            while (c <= 'z') {
                synchronized (tag) {
                    while (!tag.getTag()) {
                        try {
                            tag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(" " + (c++));
                    tag.setTag(false);
                    tag.notify();
                }

            }
        }
    }

    public static void main(String[] args) {
        ThreadNotification threadNotification = new ThreadNotification();
        DemoOne demoOne = threadNotification.new DemoOne();
        DemoTwo demoTwo = threadNotification.new DemoTwo();
        Thread threadOne = new Thread(demoOne);
        Thread threadTwo = new Thread(demoTwo);
        threadOne.start();
        System.out.println("thread 1启动");
        threadTwo.start();
        System.out.println("thread 2启动");
    }
}
