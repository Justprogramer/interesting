package com.tao.algorithm;

import java.util.Arrays;

/**
 * author: TAOPENG
 * time ： 2019/3/21
 **/
public class SelectSort {
    public void selectSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] a = {12, 23, 5, 1, 6, 2, 6345, 3, 123, 6};
        selectSort.selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
