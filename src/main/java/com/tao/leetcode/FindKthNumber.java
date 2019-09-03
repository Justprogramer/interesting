package com.tao.leetcode;

import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/9/1
 * @description: <p>
 * </p>
 **/
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n + 1;
        int mid, count;
        while (lo < hi) {
            mid =  (hi + lo) / 2;
            count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    public void test() {
        System.out.println(findKthNumber(3, 3, 5));
    }
}
