package com.tao;

public class Main {
    public static void main(String[] args) {
        int i = (1 ^ 0xffffffff) + 1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }
}