package com.tao.leetcode;

/**
 * @author: Penger
 * @time: 2019/8/28
 * @description: <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // min[i][j] 表示从开始到[i,j]处的最小路径和，和UniquePath.java思想一样
        int[][] min = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    min[i][j] = min[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    min[i][j] = min[i][j - 1] + grid[i][j];
                } else {
                    min[i][j] = grid[i][j];
                }
            }
        }
        return min[m - 1][n - 1];
    }
}
