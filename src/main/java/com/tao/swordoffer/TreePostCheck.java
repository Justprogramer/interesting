package com.tao.swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p> 检查一个序列是不是一棵二叉排序树的后序遍历
 * </p>
 * @solution: 二叉排序树的后序遍历序列最后一个数一定是根节点root
 * 左节点 < 根节点 < 右节点, 根据这个区分根节点的左右子树，再递归判断，右边如果存在比根节点小的，说明不是合法序列
 **/
public class TreePostCheck {
    private static boolean verifySequenceOfBST(int[] sequence) {
        return sequence.length != 0
                && (sequence.length == 1 || judge(sequence, 0, sequence.length - 1));
    }

    private static boolean judge(int[] sequence, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = sequence[end];
        int leftIndex = begin;
        // 找到左子树的部分
        for (int i = begin; i <= end; i++) {
            if (sequence[i] < root) {
                leftIndex = i;
            } else {
                break;
            }
        }
        //判断右子树是否存在小于根节点的节点，存在则说明不合法
        for (int i = leftIndex + 1; i <= end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return judge(sequence, begin, leftIndex)
                && judge(sequence, leftIndex + 1, end);
    }

    public static void main(String[] args) {
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifySequenceOfBST(sequence));
    }
}
