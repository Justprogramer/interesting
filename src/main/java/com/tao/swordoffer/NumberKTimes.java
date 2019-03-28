package com.tao.swordoffer;

import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>统计一个数字在排序数组中出现的次数。
 * </p>
 * @solution: 有序数组，直接使用二分查找，找比 k - 0.5大的第一个位置，比 k + 0.5 小的第一个位置
 **/
public class NumberKTimes {
    private int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = biSearch(array, k - 0.5);
        int end = biSearch(array, k + 0.5);
        return end - start;
    }

    private int biSearch(int[] array, double k) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;

    }

    @Test
    public void test() {
        int[] array = {3, 3, 3, 3};
        System.out.println(getNumberOfK(array, 3));
    }
}
