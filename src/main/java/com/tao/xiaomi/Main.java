package com.tao.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/11
 * @description: <p>
 * </p>
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        Integer[] sortNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sortNums[i] = nums[i];
        }
        int countOne = 0;
        int countTwo = 0;
        Arrays.sort(sortNums);
        for (int i = 0; i < n; i++) {
            if (sortNums[i] != nums[i]) {
                countOne++;
            }
            if (sortNums[n - 1 - i] != nums[i]) {
                countTwo++;
            }
        }
        if (countTwo == 0) {
            System.out.println(countOne / 2);
            return;
        }


    }
}
