package com.tao.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/13
 * @description: <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
@Slf4j
public class RegexCheck {
    /**
     * 首先，对比两个字符串的首字母
     * 如果不相等可能会有以下两种情况
     * 1. bbb 和 a*b*,这种情况可能是a的已经比较完成，需要跳过p的前2个字符再比较剩下的字符串，根据p的特征进行判断
     * 2. aaabbb 和 b*,这种情况直接是不相等，会被直接返回，不需要比较后面的字符串
     * 相等时，需要比较之后的字符串，每次相等时，需要把s往后移1位，根据p是否可能会带*分别判断p后移的位数
     * @param s string
     * @param p pattern
     * @return match result
     */
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        boolean firstMatch = (s != null && s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return firstMatch && isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    @Test
    public void test() {
        log.info("{}", isMatch("aaaabbb", "a*b.*b"));
    }
}
