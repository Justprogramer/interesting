package com.tao.leetcode;

/**
 * @author: Penger
 * @time: 2019/8/28
 * @description: <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m <= 0 && n <= 0) {
            return 0;
        }
        //path[i][j]表示由起始位置到[i,j]的路径总数
        int[][] path = new int[m][n];
        // 当前位置总是由上方或者左方到达的，所以 path[i][j] = path[i-1][j]+path[i][j-1]
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (i > 0 && j > 0) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else if (i > 0) {
                    path[i][j] = path[i - 1][j];
                } else if (j > 0) {
                    path[i][j] = path[i][j - 1];
                } else {
                    path[i][j] = 1;
                }
            }
        }
        return path[m - 1][n - 1];
    }
}
