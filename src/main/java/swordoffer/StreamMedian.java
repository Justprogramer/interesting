package swordoffer;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p>如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * </p>
 * @solution: 使用堆，构建两个堆，左边最大堆，右边最小堆，保证最大堆的最大数比最小堆的要小，每次插入完成后调整两个堆的数量大小，保证<b>最大堆-最小堆 = 0 或者 1</b>
 **/
public class StreamMedian {
    /**
     * 左边最大堆
     */
    private static PriorityQueue<Integer> lHeap = new PriorityQueue<>(15, (o1, o2) -> o2 - o1);
    /**
     * 右边最小堆
     */
    private static PriorityQueue<Integer> rHeap = new PriorityQueue<>();

    /**
     * 保证lHeap.size()>=rHeap.size()
     */
    private static void insert(int num) {
        // 先按大小插入
        if (lHeap.isEmpty() || num < lHeap.peek()) {
            lHeap.add(num);
        } else {
            rHeap.add(num);
        }
        //调整左右堆的数量
        if (rHeap.size() > lHeap.size()) {
            lHeap.add(rHeap.poll());
        } else if (lHeap.size() - rHeap.size() == 2) {
            rHeap.add(lHeap.poll());
        }
    }

    private static Double getMedian() {
        if (rHeap.size() == lHeap.size()) {
            return (lHeap.peek() + rHeap.peek()) / 2.0;
        } else {
            return lHeap.peek() + 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            insert(num);
            System.out.println(getMedian());
        }
    }
}
