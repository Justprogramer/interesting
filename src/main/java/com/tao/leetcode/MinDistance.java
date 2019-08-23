package com.tao.leetcode;

import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/23
 * @description: <p>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 用 distance[i][j] 表示从 word[0..i) 转换到 word[0..j) 的最小操作
        int[][] distance = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = 1 + Math.min(distance[i - 1][j], Math.min(distance[i - 1][j - 1], distance[i][j - 1]));
                }
            }
        }
        return distance[n][m];
    }
    @Test
    public void test(){
        System.out.println(minDistance("hallyluya","helloworld"));
    }
}
