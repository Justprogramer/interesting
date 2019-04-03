package com.tao.neteasy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/4/2
 * @description: <p>
 * 从给定的N数组里面找出 Ai, Aj, Ak (0<=i<j<k<=N),要求Ai, Aj, Ak的最大公约数为1
 * 给出一共有多少种情况
 * 比如：1，2，3，4，5
 * 有 ：1，2，3；1，2，4；1，2，5；1，3，4；1，3，5；1，4，5；2，3，4；2，3，5；2，4，5；3，4，5；一共10种
 * </p>
 **/
public class CommonDivisor {

    private static boolean[] tag;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tag = new boolean[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        solve(nums, 0, 3);
        System.out.println(count);
    }

    private static void solve(int[] nums, int start, int k) {
        if (k == 0) {
            if (check(nums)) {
                System.out.println("true");
                count++;
            }
        } else {
            if (start == nums.length) {
                return;
            }
            tag[start] = true;
            if (k <= 3 && start < nums.length) {
                solve(nums, start + 1, k - 1);
            }
            tag[start] = false;
            if (k > 0 && start < nums.length) {
                solve(nums, start + 1, k);
            }
        }
    }

    private static boolean check(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(3);
        for (int i = 0; i < tag.length; i++) {
            if (tag[i]) {
                list.add(nums[i]);
            }
        }
        int a = list.size() == 3 ? list.get(0) : 0;
        int b = list.size() == 3 ? list.get(1) : 0;
        int c = list.size() == 3 ? list.get(2) : 0;
        System.out.println(a + " " + b + " " + c);
        if ((a & 0x1) != 1 && (b & 0x1) != 1 && (c & 0x1) != 1) {
            return false;
        }
        if (a == 1 || b == 1 || c == 1) {
            return true;
        }
        return check(a, b) || check(a, c) || check(c, b);
    }

    private static boolean check(int a, int b) {
        if ((a & 0x1) != 1 && (b & 0x1) != 1) {
            return false;
        }
        int min = Math.min(a, b);
        for (int i = 1; i < Math.sqrt(min); ) {
            i = i * 2 + 1;
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = new int[1000];
        for (int i = 1; i <= 1000; i++) {
            nums[i-1] = i;
        }
        tag = new boolean[nums.length];
        solve(nums, 0, 3);
        System.out.println(count);

    }
}
