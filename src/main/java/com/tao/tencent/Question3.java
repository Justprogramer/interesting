package com.tao.tencent;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/4/5
 * @description: <p>
 * </p>
 **/
public class Question3 {
    private static int result = Integer.MAX_VALUE;
    private static double[] powers;
    private static int[] golds;
    private static boolean[] flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numbers = scanner.nextInt();
            if (numbers <= 0) {
                System.out.println(0);
                return;
            }
            powers = new double[numbers];
            golds = new int[numbers];
            flag = new boolean[numbers];
            for (int i = 0; i < numbers; i++) {
                powers[i] = scanner.nextInt();
            }
            for (int i = 0; i < numbers; i++) {
                golds[i] = scanner.nextInt();
            }
            parse(0, 0, 0);
            System.out.println(result);
        }
    }

    private static void parse(int start, int money, int power) {
        if (start >= powers.length) {
            result = Math.min(result, money);
        } else if (power >= powers[start]) {
            parse(start + 1, money, power);
        } else {
            flag[start] = true;
            power += powers[start];
            money += golds[start];
            parse(start + 1, money, power);
            for (int i = start + 1; i < powers.length; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    power += powers[i];
                    money += golds[i];
                    parse(i + 1, money, power);
                    flag[i] = false;
                }
            }
            flag[start] = false;
        }

    }
}
