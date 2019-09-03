package com.tao.leetcode;

/**
 * @author: Penger
 * @time: 2019/9/3
 * @description: <p>
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 地的数量小于花的数量，直接返回false
        if (flowerbed.length == 0 || flowerbed.length < n) {
            return false;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            // 如果当前地已经种了花，就不再考虑
            if (flowerbed[i] == 1) {
                continue;
            }
            // 使用pre记录当前地前一块是否种了花，需要考虑 i == 0的情况
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            // 使用next记录当前地后一块是否种了花，需要考虑 i == flowerbed.length - 1 的情况
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            // pre 和 next 都没有种花，说明当前地可以种花，将n减一
            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
            // 判断n是否小于零，小于说明已经满足，直接返回true
            if (n <= 0) {
                return true;
            }
        }
        return n <= 0;
    }
}
