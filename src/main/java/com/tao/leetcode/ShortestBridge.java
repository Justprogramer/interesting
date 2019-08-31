package com.tao.leetcode;

import java.util.ArrayDeque;

/**
 * @author: Penger
 * @time: 2019/8/31
 * @description: <p>
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class ShortestBridge {
    private int[][] changePosition = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private ArrayDeque<int[]> queue = new ArrayDeque<>();

    public int shortestBridge(int[][] A) {
        if (A.length == 0) {
            return -1;
        }
        firstBridge:
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = 0; j <= A[0].length - 1; j++) {
                if (A[i][j] == 1) {
                    findEdge(A, i, j);
                    break firstBridge;
                }
            }
        }
        while (true) {
            if (queue.isEmpty()) {
                return -1;
            }
            int[] edge = queue.poll();
            for (int k = 0; k <= changePosition.length - 1; k++) {
                int i = edge[0] + changePosition[k][0];
                int j = edge[1] + changePosition[k][1];
                if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
                    continue;
                }
                if (A[i][j] == 1) {
                    return A[edge[0]][edge[1]] - 1;
                }
                if (A[i][j] == 0) {
                    A[i][j] = A[edge[0]][edge[1]] + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

    // DFS
    public void findEdge(int[][] A, int i, int j) {
        A[i][j] = -1;
        for (int k = 0; k <= changePosition.length - 1; k++) {
            int i1 = i + changePosition[k][0];
            int j1 = j + changePosition[k][1];
            if (i1 < 0 || j1 < 0 || i1 >= A.length || j1 >= A[0].length) {
                continue;
            }
            if (A[i1][j1] == 1) {
                findEdge(A, i1, j1);
            } else if (A[i1][j1] == 0) {
                A[i1][j1] = 2;
                queue.add(new int[]{i1, j1});
            }
        }
    }
}
