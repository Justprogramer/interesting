package com.tao.leetcode;

import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/29
 * @description: <p>
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        if (str.length <= 1) {
            return num;
        }
        //记录0-9个字母出现的最后一个位置
        int[] last = new int[10];
        for (int i = 0; i <= str.length - 1; i++) {
            last[str[i] - '0'] = i;
        }
        // 扫描字符串，将当前位置和每个last[k]（0-9）进行比较
        // 如果当前位置(str[i])字符小于k(0到9中的一个值)，并且k在字符串这个位置之后出现（last[k] > i），两者进行交换一定能达到交换一次的最大值
        for (int i = 0; i <= str.length - 1; i++) {
            for (int k = last.length - 1; k >= 0; k--) {
                if (k > str[i] - '0' && last[k] > i) {
                    char temp = str[i];
                    str[i] = str[last[k]];
                    str[last[k]] = temp;
                    return Integer.parseInt(String.valueOf(str));
                }
            }
        }
        return Integer.parseInt(String.valueOf(str));
    }
    @Test
    public void test(){
        System.out.println(maximumSwap(98368));
    }
}
