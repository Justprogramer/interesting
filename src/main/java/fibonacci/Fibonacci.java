package fibonacci;

/**
 * @author: Penger
 * @time ： 2019/3/22
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
            for (int i = 0; i < n; i++) {
                System.out.print(n + " ");
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
        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciLoop(10));
        fibonacciLoopPrint(10);
    }
}
