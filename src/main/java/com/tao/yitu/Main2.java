package com.tao.yitu;

import java.util.*;

/**
 * @author: Penger
 * @time: 2019/9/6
 * @description: <p>
 *     消灭星星
 * </p>
 **/
public class Main2 {
    private static int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static List<int[]> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int k = 0; k < m; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(clear(matrix, i, j));
        }
    }

    private static String clear(int[][] matrix, int i, int j) {
        int[][] tag = new int[matrix.length][matrix.length];
        list = new ArrayList<>();
        dfs(matrix, i, j, tag);
        if (list.size() == 0) {
            return "empty!";
        }
        if (list.size() == 1) {
            return "only one!";
        }
        for (int[] m : list) {
            matrix[m[0] - 1][m[1] - 1] = 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int[] m : list) {
            int columnSum = rowMatrix(matrix, m[0], m[1]);
            if (columnSum == 0 && m[0] == 1) {
                set.add(m[1]);
            }
        }
        for (Integer s : set) {
            columnMatrix(matrix, s);
        }
        return list.size() + "";
    }

    private static void dfs(int[][] matrix, int i, int j, int[][] tag) {
        if (i > matrix.length || j > matrix.length || i < 1 || j < 1 || matrix[i - 1][j - 1] == 0) {
            return;
        }
        list.add(new int[]{i, j});
        tag[i - 1][j - 1] = 1;
        for (int[] m : move) {
            int k = i + m[0];
            int v = j + m[1];
            if (k > matrix.length || v > matrix.length || k < 1 || v < 1) {
                continue;
            }
            if (tag[k - 1][v - 1] == 0 && matrix[k - 1][v - 1] == matrix[i - 1][j - 1] && matrix[k - 1][v - 1] != 0) {
                dfs(matrix, k, v, tag);
            }
        }
    }

    private static int rowMatrix(int[][] matrix, int i, int j) {
        int sum = matrix[i - 1][j - 1];
        for (; i <= matrix.length; i++) {
            if (i == matrix.length) {
                matrix[i - 1][j - 1] = 0;
            } else {
                matrix[i - 1][j - 1] = matrix[i][j - 1];
            }
            sum += matrix[i - 1][j - 1];
        }
        return sum;
    }

    private static void columnMatrix(int[][] matrix, int j) {
        for (; j <= matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (j == matrix.length) {
                    matrix[i][j - 1] = 0;
                } else {
                    matrix[i][j - 1] = matrix[i][j];
                }
            }
        }
    }
}
