package com.tao.swordoffer;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * </p>
 * @solution: 使用两个Vector, 一个放奇数，一个放偶数
 * 或者使用冒泡排序的方法，比较相邻的两个数，如果是偶数在前就将位置对调
 **/
public class ChangeOddAndEvenPositon {
    private static void reOrderArrayWithVector(int[] array) {
        Vector<Integer> odd = new Vector<>();
        Vector<Integer> even = new Vector<>();
        for (int arr : array) {
            if ((arr & 0x1) == 0) {
                odd.add(arr);
            } else {
                even.add(arr);
            }
        }
        even.addAll(odd);
        for (int i = 0; i < even.size(); i++) {
            array[i] = even.get(i);
        }
    }

    private static void reOrderArrayWithBubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if ((array[j] & 0x1) == 0 && (array[j + 1] & 0x1) == 1) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reOrderArrayWithVector(array);
        System.out.println(Arrays.toString(array));
        int[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reOrderArrayWithBubble(arrayTwo);
        System.out.println(Arrays.toString(arrayTwo));
    }
}
