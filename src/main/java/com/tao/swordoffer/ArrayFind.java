package com.tao.swordoffer;

/**
 * @author: Penger
 * @time ： 2019/3/22
 * @description: <p>在一个二维数组中（每个一维数组的长度相同）
 * ，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * </p>
 * @solution: <p> 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
 * 因此从右上角开始查找，
 * 当要查找数字比右上角数字大时，下移；
 * 当要查找数字比右上角数字小时，左移；
 * 如果出了边界，则说明二维数组中不存在该整数
 * </p>
 **/
public class ArrayFind {

    private static boolean find(int[][] array, int target) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array[0].length - 1;
        int n = 0;
        int temp = array[n][m];
        while (target != temp) {
            if (m > 0 && n < array.length - 1) {
                if (temp < target) {
                    n++;
                } else {
                    m--;
                }
                temp = array[n][m];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        System.out.println(find(a, 9));
    }
}
