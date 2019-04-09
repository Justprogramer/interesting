package com.tao.swordoffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/4/9
 * @description: <p>
 * 把字符串转成整数，不能使用jdk的函数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 * </p>
 * @solution: 遍历字符串，从左往右，合法则将sum*10+当前数；不合法则返回0
 **/
@Slf4j
public class StrToInt {
    private int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sum = 0;
        boolean tag = true;
        char[] chars = str.toCharArray();
        if (chars[0] == '-') {
            tag = false;
        }
        for (char c : chars) {
            if (c == '+' || c == '-') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                sum = (c - '0') + sum * 10;
            } else {
                return 0;
            }
        }
        return tag ? sum : -sum;
    }

    @Test
    public void test() {
        String s = "-12211231";
        log.info("str to int:{}", strToInt(s));
    }
}
