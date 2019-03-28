package com.tao.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: Penger
 * @time: 2019/3/27
 * @description: <p>输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * </p>
 * @solution: <p>
 * 方法一：使用快排的思想，不需要全排序，进行partition的时候如果正好等于k,直接返回，取前k个数；如果大于k,说明在右边，对右边进行排序；若果小于k,说明在左边，对左边排序
 * 方法二：先对数组排序，然后取出前k个
 * 方法三：利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆
 * </p>
 **/
public class LeastKNumber {
    /**
     * 方法一
     */
    private static ArrayList<Integer> getKLeastNum(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        quickSort(input, 0, input.length - 1, k);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static void quickSort(int[] input, int left, int right, int k) {
        int mid = partition(input, left, right);
        if (mid == k) {
            return;
        }
        if (left < mid - 1 && k < mid) {
            quickSort(input, left, mid - 1, k);
            return;
        }
        if (mid < right && k > mid) {
            quickSort(input, mid, right, k);
        }
    }

    private static int partition(int[] input, int start, int end) {
        int mid = (start + end) >> 1;
        int pivot = input[mid];
        while (start < end) {
            while (input[start] < pivot) {
                start++;
            }
            while (input[end] > pivot) {
                end--;
            }
            if (start < end) {
                input[start] = input[start] + input[end];
                input[end] = input[start] - input[end];
                input[start] = input[start] - input[end];
                start++;
                end--;
            } else if (start == end) {
                start++;
            }
        }
        return start;
    }

    /**
     * 方法二
     */
    public ArrayList<Integer> getKLeastNum2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (input == null || k == 0 || k > input.length) {
            return res;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 方法三
     */
    public ArrayList<Integer> getKLeastNum3(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k == 0 || k > input.length) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (e1, e2) -> e2 - e1);
        for (int anInput : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(anInput);
            } else {
                if (maxHeap.peek() > anInput) {
                    maxHeap.poll();
                    maxHeap.offer(anInput);
                }
            }
        }
        res.addAll(maxHeap);
        return res;
    }


    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8, 1, 1, 1, 1};
        System.out.println(getKLeastNum(input, 4));
    }
}
