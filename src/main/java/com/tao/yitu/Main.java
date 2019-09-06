package com.tao.yitu;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/6
 * @description: <p>
 * </p>
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][][] matrix = new int[k][n][m];
        for (int v = 0; v < k; v++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[v][i][j] = scanner.nextInt();
                }
            }
        }
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int v = 0; v < k; v++) {
                    sum += matrix[v][i][j];
                }
                if (sum != 0 && sum != k) {
                    count++;
                }
                sum = 0;
            }
        }
        System.out.println(m * n - count);
    }
}
