package com.tao.neteasy;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Penger
 * @time: 2019/4/2
 * @description: <p>
 * 输入：I have a cat;
 * 输出：;cat a have I
 * 单词内包括符号，需要将符号两边的单词进行对换： aaa-bbb-ccc --> ccc-bbb-aaa
 * </p>
 **/
public class ReverseSentence {
    private static Pattern pattern = Pattern.compile("[,.\\-';:`&#$%()@!+/|]");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.nextLine();
            if (next == null || next.length() == 0) {
                System.out.println("");
            }else {
                String[] strs = next.split(" ");
                StringBuilder result = new StringBuilder();
                for (int i = strs.length -1; i >= 0; i--) {
                    if (checkIsStr(strs[i])) {
                        result.append(reverseStr(strs[i])).append(" ");
                    } else {
                        result.append(strs[i]).append(" ");
                    }
                }
                System.out.println(result.toString().trim());
            }
        }
    }

    private static boolean checkIsStr(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static String reverseStr(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (checkIsStr(String.valueOf(str.charAt(i)))) {
                stack.push(str.substring(start, i));
                stack.push(str.substring(i, i + 1));
                start = i + 1;
            }
        }
        if (start < str.length()) {
            stack.push(str.substring(start, str.length()));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "s--100'w";
        System.out.println(reverseStr(s));
    }

}
