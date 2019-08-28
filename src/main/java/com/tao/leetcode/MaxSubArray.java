package com.tao.leetcode;

/**
 * @author: Penger
 * @time: 2019/8/28
 * @description: <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[] sum = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            sum[i] = Math.max(nums[i], nums[i] + (i >= 1 ? sum[i - 1] : 0));
            res = Math.max(res, sum[i]);
        }
        return res;
    }
}
