package com.tao.neteasy;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/7
 * @description: <p>
 * </p>
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            t--;
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            int[] month = new int[30];
            while (m > 0) {
                int i = scanner.nextInt();
                month[i - 1] = 1;
                m--;
            }
            System.out.println(coffee(month, k));
        }
    }

    private static int coffee(int[] month, int k) {
        for (int i = 0; i < month.length; i++) {
            if (month[i] == 1) {
                continue;
            }
            if (checkDuration(month, i, k)) {
                month[i] = 1;
            }
        }
        int sum = 0;
        for (int m : month) {
            sum += m;
        }
        return sum;
    }

    private static boolean checkDuration(int[] month, int i, int k) {
        int max = i + k > month.length - 1 ? month.length - 1 : i + k;
        int min = i - k < 0 ? 0 : i - k;
        for (i = min; i <= max; i++) {
            if (month[i] == 1) {
                return false;
            }
        }
        return true;
    }
}

//4
//0 10
//1 2 3 4 5 6 7 8 9 10
//1 15
//1 3 5 7 9 11 13 15 17 19 21 23 25 27 29
//1 7
//5 9 13 17 21 25 29
//1 0