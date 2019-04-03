package com.tao.neteasy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/30
 * @description: <p>
 * 输入一个01代表的二维矩阵，0代表海洋，1代表陆地，海洋高度为0，陆地高度最少为1，要求相邻高度差不能超过1
 * 输出最大高度
 * 比如：
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1
 * 1 1 1 1
 * 高度可以是
 * 0 1 2 3
 * 0 0 1 2
 * 1 1 2 3
 * 1 2 3 4
 * 所以最大高度是4
 * </p>
 **/
public class MaxEarthHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int[] m : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                m[i] = scanner.nextInt();
            }
        }
        System.out.println(solve(matrix));
    }

    public static int solve(int[][] matrix) {
        int[][] res = find(matrix);
        System.out.println(Arrays.deepToString(res));
        int max = 0;
        for (int[] re : res) {
            for (int i = 0; i < res[0].length; i++) {
                if (re[i] > max) {
                    max = re[i];
                }
            }
        }
        return max;
    }

    public static int[][] find(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                temp[j][i] = matrix[j][i];
                if (matrix[j][i] != 0) {
                    if (j == 0 && i == 0 && j + 1 < matrix.length && i + 1 < matrix[0].length
                            && matrix[j + 1][i] == matrix[j][i + 1]
                            && matrix[j][i] == matrix[j][i + 1]
                            && matrix[j + 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (j == 0 && i == matrix[0].length - 1 && j + 1 < matrix.length
                            && matrix[j][i - 1] == matrix[j + 1][i]
                            && matrix[j][i - 1] == matrix[j][i]
                            && matrix[j + 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (i == 0 && j == matrix.length - 1 && i + 1 < matrix[0].length
                            && matrix[j - 1][i] == matrix[j][i + 1]
                            && matrix[j - 1][i] == matrix[j][i]
                            && matrix[j - 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (i == matrix[0].length - 1 && j == matrix.length - 1
                            && matrix[j - 1][i] == matrix[j][i - 1]
                            && matrix[j - 1][i] == matrix[j][i]
                            && matrix[j - 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (j == 0 && i > 0 && j + 1 < matrix.length && i + 1 < matrix[0].length
                            && matrix[j][i - 1] == matrix[j][i + 1]
                            && matrix[j + 1][i] == matrix[j][i + 1]
                            && matrix[j + 1][i] == matrix[j][i]
                            && matrix[j + 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }

                    if (i == 0 && j > 0 && j + 1 < matrix.length && i + 1 < matrix[0].length
                            && matrix[j + 1][i] == matrix[j][i + 1]
                            && matrix[j + 1][i] == matrix[j - 1][i]
                            && matrix[j + 1][i] == matrix[j][i]
                            && matrix[j + 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }

                    if (i > 0 && j > 0 && i + 1 < matrix[0].length && j + 1 < matrix.length
                            && matrix[j - 1][i] == matrix[j][i + 1]
                            && matrix[j - 1][i] == matrix[j + 1][i]
                            && matrix[j - 1][i] == matrix[j][i - 1]
                            && matrix[j - 1][i] == matrix[j][i]
                            && matrix[j - 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (i > 0 && j == matrix.length - 1 && i + 1 < matrix[0].length
                            && matrix[j - 1][i] == matrix[j][i + 1]
                            && matrix[j - 1][i] == matrix[j][i - 1]
                            && matrix[j - 1][i] == matrix[j][i]
                            && matrix[j - 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                    if (i == matrix[0].length - 1 && j > 0 && j + 1 < matrix.length
                            && matrix[j - 1][i] == matrix[j + 1][i]
                            && matrix[j - 1][i] == matrix[j][i - 1]
                            && matrix[j - 1][i] == matrix[j][i]
                            && matrix[j - 1][i] != 0) {
                        temp[j][i] = matrix[j][i] + 1;
                    }
                }
            }
        }
        boolean tag = false;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (temp[j][i] > matrix[j][i]) {
                    tag = true;
                    break;
                }
            }
        }
        matrix = temp;
        if (tag) {
            return find(matrix);
        }
        return matrix;
    }
}
