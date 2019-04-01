package com.tao.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p> 从给定数组里面找出所有和为N的子序列
 * </p>
 * @solution: <p>
 * 先排序，从后向前组合，越靠前数值越小
 * 使用回溯法，将当前数字和目标值比较，小的话默认将其加入当前这个序列,更新目标值和查找值，进入递归，
 * 递归结束后将当前位置取出这个序列，恢复目标值，进行下一个查找
 * 如果当前值直接大于目标值，直接跳过当前位置，进行下一个比较
 * 如果查找到第一个，跳出递归
 * </p>
 **/
public class SumIsN {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private boolean[] tag;

    private void find(int[] array, int n) {
        if (n == 0 || array == null || array.length == 0) {
            return;
        }
        Arrays.sort(array);
        tag = new boolean[array.length];
        parse(array, array.length - 1, n);
    }

    private void parse(int[] array, int end, int n) {
        if (end < 0) {
            return;
        }
        if (array[end] - n == 0) {
            // 找到最后一个数，将目前标记的序列保存
            tag[end] = true;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < tag.length; i++) {
                if (tag[i]) {
                    temp.add(array[i]);
                }
            }
            result.add(temp);
            // 将当前的标志位重置，继续向前查找是否有满足的序列
            tag[end] = false;
            parse(array, end - 1, n);
        } else {
            // 将当前位置标记，放入尝试有没有可能满足的子序列
            tag[end] = true;
            if (n - array[end] > 0) {
                parse(array, end - 1, n - array[end]);
            }
            // 将当前位置重置，向前查找是否有满足的子序列
            tag[end] = false;
            if (n >= 0) {
                parse(array, end - 1, n);
            }
        }
    }

    @Test
    public void test() {
        int[] array = {10,10,10,7,7,7,7,7,7,6,6,6};
        find(array, 30);
        System.out.println(result);
    }
}
