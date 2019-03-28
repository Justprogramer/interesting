package com.tao.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * </p>
 * @solution: <p>
 * 方法一：利用快排的思想，交换的时候不是根据大小，而是根据自定义的字符串排序
 * 方法二：先将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序的字符串数组拼接出来。
 * 关键就是制定排序规则：
 * 若ab > ba 则 a > b
 * 若ab < ba 则 a < b
 * 若ab = ba 则 a = b
 * </p>
 **/
public class PrintMinNumber {
    private static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        quickSort(numbers, 0, numbers.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    private static void quickSort(int[] numbers, int left, int right) {
        int partition = partition(numbers, left, right);
        if (left < partition - 1) {
            quickSort(numbers, left, partition - 1);
        }
        if (right > partition) {
            quickSort(numbers, partition, right);
        }
    }

    private static int partition(int[] numbers, int left, int right) {
        int mid = (left + right) >> 1;
        int pivot = numbers[mid];
        while (left < right) {
            while (left < mid && check(numbers[left] + "", pivot + "")) {
                left++;
            }
            while (right > mid && check(pivot + "", numbers[right] + "")) {
                right--;
            }
            if (left < right) {
                numbers[left] = numbers[left] + numbers[right];
                numbers[right] = numbers[left] - numbers[right];
                numbers[left] = numbers[left] - numbers[right];
                left++;
                right--;
            } else if (left == right) {
                left++;
            }
        }
        return left;
    }

    private static boolean check(String num1, String num2) {
        String s1 = num1 + num2;
        String s2 = num2 + num1;
        return s1.compareTo(s2) <= 0;
    }

    /**
     * 方法二
     */
    public static String printMinNumberTwo(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return String.valueOf(numbers[0]);
        }
        StringBuilder res = new StringBuilder();
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });
        for (int i = 0; i < len; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] a = {3334, 3, 3333332};
//        int[] a = {3, 2,1};
        System.out.println(printMinNumber(a));
    }
}
