package com.tao.swordoffer;

import java.util.HashSet;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * </p>
 **/
public class FindNumsAppearOnece {
    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }
        Integer[] temp = set.toArray(new Integer[]{});
        num1[0] = temp[0];
        num2[0] = temp[1];
    }
}
