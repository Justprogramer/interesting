package com.tao.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/26
 * @description: <p>输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * </p>
 * @solution: 第一步求所有可能出现在第一个位置的字符（即把第一个字符和后面的所有字符交换[相同字符不交换]）；
 * 第二步固定第一个字符，求后面所有字符的排列。
 * 这时候又可以把后面的所有字符拆成两部分（第一个字符以及剩下的所有字符），依此类推。
 * 这样，我们就可以用递归的方法来解决。
 **/
public class StringPermutation {
    private static ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        char[] old = str.toCharArray();
        permutationHelper(old, 0, list);
        Collections.sort(list);
        return list;
    }

    private static void permutationHelper(char[] str, int start, ArrayList<String> res) {
        if (start == str.length - 1) {
            res.add(String.valueOf(str));
        } else {
            for (int j = start; j < str.length; j++) {
                if (j != start && str[start] == str[j]) {
                    continue;
                }
                swap(str, start, j);
                permutationHelper(str, start + 1, res);
                swap(str, start, j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(permutation(str));
        }
    }

}
