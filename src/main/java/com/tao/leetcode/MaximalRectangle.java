package com.tao.leetcode;

import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/8/29
 * @description: <p>
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + (j >= 1 ? dp[i][j - 1] : 0);
                } else {
                    dp[i][j] = 0;
                }
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    maxArea = Math.max(maxArea, width * (i - k + 1));
                }
            }
        }
        return maxArea;
    }

    public int maximalRectangleII(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i <= m -1 ; i++) {
            for(int j = 0; j <= n - 1; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 +( i >= 1 ? dp[i-1][j] : 0);
                } else {
                    dp[i][j] = 0;
                }
                while(stack.peek() != -1 && dp[i][stack.peek()] >= dp[i][j]){
                    maxArea = Math.max(maxArea, dp[i][stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while(stack.peek() != -1){
                maxArea = Math.max(maxArea, dp[i][stack.pop()] * (n - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
