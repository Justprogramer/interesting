package swordoffer;

import java.util.ArrayList;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>顺时针打印矩阵
 * </p>
 * @solution: 将矩阵一层层剥开，使用递归式的剥洋葱
 **/
public class ColockMatrixPrint {
    private static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> results = new ArrayList<>();
        printMatrix(matrix, 0, matrix[0].length, 0, matrix.length, results);
        return results;
    }

    private static void printMatrix(int[][] matrix, int xStart, int xEnd, int yStart, int yEnd, ArrayList<Integer> results) {
        if (xStart >= xEnd || yStart >= yEnd) {
            return;
        }
        for (int i = xStart; i < xEnd; i++) {
            // 打印上边 j-> xStart:xEnd-1   i = yStart
            results.add(matrix[yStart][i]);
        }
        for (int j = yStart + 1; j < yEnd; j++) {
            // 打印右边 j = xEnd - 1    i-> yStart+1:yEnd-1
            results.add(matrix[j][xEnd - 1]);
        }
        if (yStart != yEnd - 1) {
            for (int i = xEnd - 2; i >= xStart; i--) {
                // 打印下边 j-> xEnd-2:xStart   i=yEnd -1
                results.add(matrix[yEnd - 1][i]);
            }
        }
        if (xStart != xEnd - 1) {
            for (int j = yEnd - 2; j >= yStart + 1; j--) {
                // 打印左边 j=xStart    i->yEnd-2:yStart+1
                results.add(matrix[j][xStart]);
            }
        }
        printMatrix(matrix, xStart + 1, xEnd - 1, yStart + 1, yEnd - 1, results);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
//        int[][] matrix = {{1}, {5}, {9}, {13},{17}};
//        int[][] matrix = {{1,2}, {5,6}, {9,10}, {13,14},{17,18}};
        System.out.println(printMatrix(matrix));
    }
}
