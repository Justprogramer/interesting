package com.tao.leetcode;

/**
 * @author: Penger
 * @time: 2019/3/26
 * @description: <p>给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * </p>
 * @solution: 方法一：暴力比较
 * 方法二：归并排序的思想，结合剑指offer上的 数组中的逆序对 解题思路
 **/
public class ReversePair {
    /**
     * 暴力搜索，超时
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length - 1;
        int count = 0;
        for (int i = 0; i <= len - 1; i++) {
            for (int j = i + 1; j <= len; j++) {
                if ((nums[i] & 0x1) == 1 && (nums[i] + 1 >> 1) > nums[j]
                        || (nums[i] & 0x1) == 0 && (nums[i] >> 1) > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 使用归并排序的思想，通过
     */
    private static int reversePairsTwo(int[] nums) {
        return reverse(nums, 0, nums.length - 1);
    }

    private static int reverse(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            int leftCount = reverse(nums, start, mid);
            int rightCount = reverse(nums, mid + 1, end);
            int[] temp = new int[end - start + 1];
            int tempIndex = end - start;
            int count = 0;
            int i = mid, j = end;
            while (i >= start && j >= mid + 1) {
                if ((nums[i] & 0x1) == 1 && (nums[i] + 1 >> 1) > nums[j]
                        || (nums[i] & 0x1) == 0 && (nums[i] >> 1) > nums[j]) {
                    i--;
                    count += j - mid;
                } else {
                    j--;
                }
            }
            i = mid;
            j = end;
            while (i >= start && j >= mid + 1) {
                if (nums[i] > nums[j]) {
                    temp[tempIndex--] = nums[i--];
                } else {
                    temp[tempIndex--] = nums[j--];
                }
            }
            while (i >= start) {
                temp[tempIndex--] = nums[i--];
            }
            while (j >= mid + 1) {
                temp[tempIndex--] = nums[j--];
            }
            tempIndex = 0;
            while (start <= end) {
                nums[start++] = temp[tempIndex++];
            }
            return leftCount + rightCount + count;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(reversePairsTwo(nums));
    }
}
