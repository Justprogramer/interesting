package com.tao.swordoffer;

import java.util.Scanner;

/**
 * @author: Penger
 * @time ： 2019/3/22
 *
 * 一个楼梯有50个台阶，每一步可以走一个台阶，也可以走两个台阶，请问走完这个楼梯共有多少种方法
 *
 **/
public class Fibonacci {
    /**
     * 使用递归求n阶斐波那契数，计算量也会随着n的增大而急剧增加
     *
     * @param n n阶
     * @return 结果
     */
    private static long fibonacciRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 使用循环计算斐波那契数，记录上一次的结果
     */
    private static long first = 0L;
    private static long second = 1L;

    private static long fibonacciLoop(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }
        first = 0L;
        second = 1L;
        long sum = 0L;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    /**
     * 使用循环计算斐波那契数，记录上一次的结果
     * 打印每次结果
     * n = 10时，输出0 1 1 2 3 5 8 13 21 34 55
     */
    private static void fibonacciLoopPrint(int n) {
        if (n < 0) {
            System.out.print(0 + " ");
        }
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                System.out.print(i + " ");
            }
        } else {
            first = 0L;
            second = 1L;
            System.out.print(first + " " + second + " ");
            for (int i = 2; i <= n; i++) {
                long sum = first + second;
                System.out.print(sum + " ");
                first = second;
                second = sum;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入quit退出，输入数字n，输出n阶斐波那契数：");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if ("quit".equals(next)) {
                break;
            } else {
                int n = Integer.valueOf(next);
                long start = System.nanoTime();
                System.out.println(fibonacciLoop(n - 1));
                long loopEnd = System.nanoTime();
                System.out.println("使用循环费时：" + (loopEnd - start));
                System.out.println(fibonacciRecursive(n - 1));
                System.out.println("使用递归费时:" + (System.nanoTime() - loopEnd));
                fibonacciLoopPrint(n - 1);
            }

        }

    }
}
