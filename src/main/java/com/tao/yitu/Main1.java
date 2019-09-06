package com.tao.yitu;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/6
 * @description: <p>
 *     地种花问题，相邻不能种
 * </p>
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(change(nums));
    }

    private static int change(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = i > 0 ? nums[i - 1] : 0;
            int next = i < nums.length - 1 ? nums[i + 1] : 0;
            if (pre == next && pre == 0 && nums[i] == 0) {
                nums[i] = 1;
                res++;
            }
        }
        return res;
    }
}
