package com.tao;

public class Main {
    public static void main(String[] args) {
        int i = (1 ^ 0xffffffff) + 1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("计算机").append("技术").toString();
        System.out.println(str2.intern() == str2);
    }
}