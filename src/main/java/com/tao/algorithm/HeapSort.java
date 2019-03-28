package com.tao.algorithm;

import java.util.Arrays;

/**
 * @author: TAOPENG
 * @time ： 2019/3/11
 **/
public class HeapSort {
    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {
        /*
         *  建堆，将数组堆化
         *  根据完全二叉树的性质，最后一个叶节点的父亲索引是 (len-1) / 2
         *  从该索引往前，依次调整最大堆
         */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private void maxHeapify(int index, int len) {
        // 左子节点索引
        int li = (index << 1) + 1;
        // 右子节点索引
        int ri = li + 1;
        // 子节点值最大索引，默认左子节点。
        int cMax = li;
        // 左子节点索引超出计算范围，直接返回。
        if (li > len) {
            return;
        }
        // 先判断左右子节点，哪个较大。
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        // 如果子节点比父节点大，不符合最大堆性质
        if (arr[cMax] > arr[index]) {
            // 交换父节点和直接点的值，
            swap(cMax, index);
            // 则需要继续判断交换后原节点的堆是否依旧符合堆的特性。
            maxHeapify(cMax, len);
        }
    }

    /**
     * 测试用例
     * <p>
     * 输出：
     * [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }

}
