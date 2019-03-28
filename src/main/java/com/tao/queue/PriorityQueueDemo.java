package com.tao.queue;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p> 使用默认Integer优先队列，构建最小堆
 * </p>
 * @insert： 100内的随机数
 * @print： 随机数打印
 **/
public class PriorityQueueDemo {
    /**
     * 构建最小堆，默认优先队列
     */
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /**
     * 构建最大堆，自定义Comparator
     */
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入100内的数字：");
        if (scanner.hasNext()) {
            int num = scanner.nextInt();
            Random random = new Random();
            for (int i = 0; i < num; i++) {
                int randomInt = random.nextInt(100);
                minHeap.add(randomInt);
                maxHeap.add(randomInt);
            }
            System.out.println("最大堆打印：");
            printHeap(maxHeap);
            System.out.println("\n最小堆打印：");
            printHeap(minHeap);
        }
    }

    private static void printHeap(PriorityQueue<Integer> heap) {
        if (heap == null) {
            System.out.println("com.tao.heap is null");
            return;
        }
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }
}
