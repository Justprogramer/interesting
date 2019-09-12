package com.tao.shunfeng;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/10
 * @description: <p>
 * </p>
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String hour = input.split(":")[0];
        String minute = input.split(":")[1];
        int hourMin = 0;
        int hourMax = Integer.MAX_VALUE;
        int num;
        int pow;
        int exp;
        for (int i = 0; i < hour.length(); i++) {
            if (Character.isDigit(hour.charAt(i))) {
                num = Integer.parseInt(hour.charAt(i) + "");
                hourMin = Math.max(hourMin, num);
            } else {
                num = hour.charAt(i) - 'A' + 10;
                hourMin = Math.max(hourMin, num);

            }
            exp = hour.length() - i - 1;
            if (num != 0 && exp != 0) {
                if (exp == 1) {
                    pow = 24 / num;
                } else {
                    pow = (int) Math.ceil(Math.log(24) / Math.log(exp)) + 1;
                }
                hourMax = Math.min(hourMax, pow);
            }
        }
        int minuteMin = 0;
        int minuteMax = Integer.MAX_VALUE;
        for (int i = 0; i < minute.length(); i++) {
            if (Character.isDigit(minute.charAt(i))) {
                num = Integer.parseInt(minute.charAt(i) + "");
                minuteMin = Math.max(minuteMin, num);
            } else {
                num = minute.charAt(i) - 'A' + 10;
                minuteMin = Math.max(minuteMin, num);
            }
            exp = minute.length() - i - 1;
            if (num != 0 && exp != 0) {
                if (exp == 1) {
                    pow = 60 / num;
                } else {
                    pow = (int) Math.ceil(Math.log10(60) / Math.log10(exp)) + 1;
                }
                minuteMax = Math.min(minuteMax, pow);
            }
        }
        hourMin = Math.max(hourMin, minuteMin);
        hourMax = Math.min(hourMax, minuteMax);
        if (hourMin == minuteMin && hourMin == 0) {
            System.out.println(0 + " ");
        } else if (hourMin < hourMax) {
            for (int i = hourMin + 1; i < hourMax; i++) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(-1 + " ");
        }
    }
}
