package com.tao.leetcode;

import java.util.ArrayList;

/**
 * @author: Penger
 * @time: 2019/3/27
 * @description: <p>
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17
 * </p>
 **/
public class FindSumSubarrayMins {
    private static int find(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += minSubArray(array, i);
        }
        return (int)(sum % (1e9 + 7));
    }

    private static long minSubArray(int[] array, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        for (; i < array.length; i++) {
            if (list.size() == 0) {
                list.add(array[i]);
            } else {
                Integer lastInt = list.get(list.size() - 1);
                list.add(lastInt > array[i] ? array[i] : lastInt);
            }
        }
        return list.stream().mapToLong(e -> e).sum();
    }

    public static void main(String[] args) {
        int[] array = {85};
        System.out.println(find(array));
    }
}
