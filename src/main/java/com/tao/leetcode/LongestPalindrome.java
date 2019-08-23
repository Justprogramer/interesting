package com.tao.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/23
 * @description: <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
@Slf4j
public class LongestPalindrome {
    /**
     * solution one, 遍历s的每一个字符，从每个字符的两侧进行拓展
     */
    private int index;
    private int length;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 判断奇数回文序列
            palindromeHelper(s, i, i);
            // 判断偶数回文序列
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + length);
    }

    private void palindromeHelper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 存在回文序列的话，左边索引应该是(left + 1),右边是(right - 1)
        // 因为 s.charAt(left) != s.charAt(right)
        // 此时回文的长度应该是 right - 1 -(left + 1) + 1 = right - left -1
        if (length < right - left - 1) {
            index = left + 1;
            length = right - left - 1;
        }
    }

    /**
     * solution two,使用动态规划
     */
    public String longestPalindromeTwo(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        // 用palindrome[i][j]表示从i到j的字符串是不是回文
        // palindrome[i][j] = palindrome[i+1][j-1] && s[i] == s[j]
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int len = 0; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                if (i == j) {
                    // 如果 i == j, palindrome = true，
                    palindrome[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (j - i == 1) {
                        // 如果 i == j - 1, palindrome[i][j] = s[i] == s[j]
                        palindrome[i][j] = b;
                    } else {
                        // 其他的就是 palindrome[i][j] = palindrome[i+1][j-1] && s[i] == s[j]
                        palindrome[i][j] = palindrome[i + 1][j - 1] && b;
                    }
                }
                if (palindrome[i][j] && j - i + 1 > length) {
                    index = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(index, index + length);
    }

    @Test
    public void test() {
        log.info("{}", longestPalindromeTwo("bb"));
    }
}
