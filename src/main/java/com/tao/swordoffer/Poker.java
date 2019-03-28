package com.tao.swordoffer;

import java.util.PriorityQueue;

/**
 * @author: Penger
 * @time: 2019/3/27
 * @description: <p>
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * </p>
 * @solution: <p>
 * 统计0的个数，使用最小堆，将堆中的两个元素进行对比，如果不是连续的用0补齐，最后判断zeroCount的正负值
 * </p>
 **/
public class Poker {
    private static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int zeroCount = 0;
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>();
        for (int number : numbers) {
            if (number == 0) {
                zeroCount++;
            } else {
                sortedQueue.add(number);
            }
        }
        if (sortedQueue.size() >= 2) {
            int num1 = sortedQueue.poll();
            while (!sortedQueue.isEmpty()) {
                int num2 = sortedQueue.poll();
                if (num1 == num2) {
                    return false;
                }
                zeroCount -= num2 - num1 - 1;
                num1 = num2;
            }
            return zeroCount >= 0;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0, 0, 1, 3, 8}));
    }
}
