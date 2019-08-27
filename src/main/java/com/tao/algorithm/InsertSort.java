package com.tao.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/27
 * @description: <p>
 * 插入排序
 * </p>
 **/
@Slf4j
public class InsertSort {
    public int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // i表示当前比较的索引，0...(i-1)表示有序的序列
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int newKey = arr[i];
            // 如果新插入的值比当前比较的值小，当前值都往后挪一个位置
            while (j >= 0 && newKey < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 排序序列里面值不大于newKey的索引+1就是插入的位置
            arr[j + 1] = newKey;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 444, 52, 14, 666, 123, 412, 86, 12, 458, 22, 999};
        log.info("{}", insertSort(arr));
    }
}
