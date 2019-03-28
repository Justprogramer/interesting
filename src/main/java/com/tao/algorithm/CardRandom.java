package com.tao.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p>
 * 提供一组卡牌，
 * 1、上面翻一张，放入oldStr列表
 * 2、再抽一张，放入卡牌组最下面
 * 3、重复1、2直到卡牌翻完
 * 给你oldStr列表，还原卡牌的最初顺序
 * </p>
 * @solution: 从oldStr最后一张卡牌开始处理，创建一个数组或队列，将最后一个卡牌直接放进去
 * 之后遇到一张新的，将数组或队列里面最后的拿出来，其余元素往后退一位，将最后的数放到前面，在将新的卡牌放到最前面
 **/
public class CardRandom {
    /**
     * 使用数组
     */
    private static void flushCard(String[] oldStr) {
        if (oldStr.length <= 2) {
            System.out.println(Arrays.toString(oldStr));
        }
        ArrayList<String> list = new ArrayList<>();

        for (int i = oldStr.length - 1; i >= 0; i--) {
            list.add(oldStr[i]);
            if (list.size() >= 2) {
                String temp = list.get(0);
                for (int i1 = 0; i1 <= list.size() - 2; i1++) {
                    list.set(i1, list.get(i1 + 1));
                }
                list.set(list.size() - 2, temp);
            }
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j) + " ");
        }
    }

    /**
     * 使用队列
     */
    private static void flushCardWithQueue(String[] oldStr) {
        if (oldStr.length <= 2) {
            System.out.println(Arrays.toString(oldStr));
            return;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = oldStr.length - 1; i >= 0; i--) {
            if (queue.isEmpty()) {
                queue.addLast(oldStr[i]);
                continue;
            }
            queue.addFirst(queue.pollLast());
            queue.addFirst(oldStr[i]);
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }

    public static void main(String[] args) {
        String[] oldStr = new String[13];
        for (int i = 0; i < 13; i++) {
            oldStr[i] = (i + 1) + "";
        }
        flushCard(oldStr);
        System.out.println();
        flushCardWithQueue(oldStr);
    }
}
