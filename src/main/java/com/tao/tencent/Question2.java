package com.tao.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/4/3
 * @description: <p>
 * </p>
 **/
public class Question2 {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.next();
            if (str.length() != n || n <= 0) {
                return;
            }
            parse(str.toCharArray());
            System.out.println(stack.size());
        }
    }

    private static void parse(char[] chars) {
        for (char aChar : chars) {
            int charInt = aChar - '0';
            if (stack.isEmpty()) {
                stack.push(charInt);
            } else {
                int popChar = stack.pop();
                if (popChar + charInt != 1) {
                    stack.push(popChar);
                    stack.push(charInt);
                }
            }
        }
    }

}
