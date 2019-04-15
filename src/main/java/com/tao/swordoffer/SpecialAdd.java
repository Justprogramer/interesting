package com.tao.swordoffer;

/**
 * @author: Penger
 * @time: 2019/4/9
 * @description: <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * </p>
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * </p>
 **/
public class SpecialAdd {

    private int add(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += add(n - 1)) > 0;
        return sum;
    }

}
