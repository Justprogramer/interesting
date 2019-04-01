package com.tao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * </p>
 * @solution: <p>
 * 很容易想到每一个子集和必须为target = sum(nums) / k，如果除不尽，那么一定会返回False。
 * 先模拟出k个子集，对于nums中最后一个数n，将其弹出。遍历k个子集，只要加入n后，这个子集和不超过target，就把它加入这个子集当中，然后带着当前的选择，继续递归搜索nums（此时nums已不包括n）。
 * 重复上述过程，如果nums最后为空，那么说明搜索成功了。
 * 这种方法十分直观，但是速度很慢，不过有一些加速方法可以采用，这里列举其中一些：
 * k个子集从前到后递归，如果当前的子集和与前一个子集和相同，那么这个子集就不用试了，因为把n放到这个子集和放到前一个子集没有差别。我们只关心能否搜索到，并不关心具体的分配方案。
 * 先把nums排序，并优先先放入最大的元素，这样能减少许多搜索路径。
 * 一旦找到nums[i] > target，那么就直接返回False。因为如果某一个元素，都超过了target，那么就一定不合题
 * </p>
 **/
public class PartitionKSubSets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, k, 0, sum / k);
    }

    public boolean helper(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return helper(nums, visited, 0, k - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || sum + nums[i] > target) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, visited, i + 1, k, sum + nums[i], target)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {4, 15, 1, 1, 1, 1, 3, 11, 1, 10};
        System.out.println(canPartitionKSubsets(nums, 3));
    }
}
