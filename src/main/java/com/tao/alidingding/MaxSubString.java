package com.tao.alidingding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Penger
 * @time: 2019/8/20
 * @description: <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串
 * 输入: "abcabcbb"
 * 输出: abc/bca/cab中的一个
 * 解释: 因为无重复字符的最长子串长度为 3。
 * </p>
 **/
public class MaxSubString {
    /**
     * solution one, 暴力遍历，使用map判断字符串是否重复,并记录它的位置索引
     * 遇到重复的字符时比较开始位置到现在的长度和上一个最大长度
     * result: 234 ms	68.6 MB
     */
    public static String maxSubStr(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> set = new HashMap<>();
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            set.put(s.charAt(i), i);
            for (int j = i + 1; j < s.length(); j++) {
                if (j == s.length() - 1 && !set.containsKey(s.charAt(j))) {
                    start = maxLength > j - i ? start : i;
                    maxLength = maxLength > j - i ? maxLength : j - i + 1;
                    i = s.length() - 1;
                    break;
                }
                if (set.containsKey(s.charAt(j))) {
                    start = maxLength > j - 1 - i ? start : i;
                    maxLength = maxLength > j - 1 - i ? maxLength : j - i;
                    set.clear();
                    break;
                } else {
                    set.put(s.charAt(j), j);
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    /**
     * solution two,使用StringBuffer或者StringBuilder,存储当前的最大长度，使用indexOf判断是否存在重复字符，
     * 根据substring获取重复字符后的字符串，比较当前sb的长度和上一个最长字符串的长度，选取最大的一个
     * result 34 ms	49.6 MB
     */
    public static String maxSubStrTwo(String str) {
        StringBuffer sb = new StringBuffer();
        String maxStr = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            int index = sb.indexOf(String.valueOf(str.charAt(i)));
            if (index < 0) {
                sb.append(str.charAt(i));
            } else {
                if (sb.length() < maxStr.length()) {
                    sb = new StringBuffer(sb.substring(index + 1)).append(str.charAt(i));
                    continue;
                }
                maxStr = sb.toString();
                sb = new StringBuffer(sb.substring(index + 1)).append(str.charAt(i));
            }
        }
        return maxStr.length() > sb.length() ? maxStr : sb.toString();
    }
}
