package com.tao.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: Penger
 * @time: 2019/8/30
 * @description: <p>
 * </p>
 **/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                while (!list.isEmpty() && list.peekLast() < nums[i]) {
                    list.pollLast();
                }
                list.addLast(nums[i]);
                continue;
            }
            while (!list.isEmpty() && list.peekLast() < nums[i]) {
                list.pollLast();
            }
            res[i - k + 1] = list.isEmpty() ? nums[i] : list.peekFirst();
            list.addLast(nums[i]);
            if (!list.isEmpty() && list.peekFirst() == nums[i - k + 1]) {
                list.pollFirst();
            }
        }
        return res;
    }

    @Test
    public void test() {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
