package com.tao.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: Penger
 * @time: 2019/8/30
 * @description: <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        // 单调队列思想
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                while (!list.isEmpty() && list.peekLast() < nums[i]) {
                    list.pollLast();
                }
                list.addLast(nums[i]);
                continue;
            }
            while (!list.isEmpty() && list.peekLast() < nums[i]) {
                list.pollLast();
            }
            res[i - k + 1] = list.isEmpty() ? nums[i] : list.peekFirst();
            list.addLast(nums[i]);
            if (!list.isEmpty() && list.peekFirst() == nums[i - k + 1]) {
                list.pollFirst();
            }
        }
        return res;
    }

    @Test
    public void test() {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
