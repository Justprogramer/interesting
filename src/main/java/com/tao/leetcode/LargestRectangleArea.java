package com.tao.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/8/28
 * @description: <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 **/
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    public int largestRectangleAreaII(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i <= heights.length - 1; i++) {
            int width = heights[i];
            for (int k = i; k >= 0; k--) {
                width = Math.min(width, heights[k]);
                maxArea = Math.max(maxArea, width * (i - k + 1));
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(largestRectangleAreaII(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }
}
