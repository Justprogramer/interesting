package com.tao.pingankeji;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/23
 * @description: <p>
 * </p>
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s");
        if (input[0].length() != input[1].length()) {
            System.out.println("false");
        }
        int[] count = new int[62];
        for (Character c1 : input[0].toCharArray()) {
            if (c1 <= '9' && c1 >= '0') {
                count[c1 - '0']++;
            } else if (c1 <= 'z' && c1 >= 'a') {
                count[c1 - 'a' + 10]++;
            } else {
                count[c1 - 'A' + 36]++;
            }
        }
        for (Character c2 : input[1].toCharArray()) {
            if (c2 <= '9' && c2 >= '0') {
                count[c2 - '0']--;
            } else if (c2 <= 'z' && c2 >= 'a') {
                count[c2 - 'a' + 10]--;
            } else {
                count[c2 - 'A' + 36]--;
            }
        }
        for (int c : count) {
            if (c != 0) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
