package com.tao.neteasy;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/7
 * @description: <p>
 * </p>
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            int num = scanner.nextInt();
            if (checkNum(num)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            n--;
        }
    }

    private static boolean checkNum(Integer num) {
        String s = Integer.toBinaryString(num);
        int mid = s.length() / 2;
        for (int i = 0; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
