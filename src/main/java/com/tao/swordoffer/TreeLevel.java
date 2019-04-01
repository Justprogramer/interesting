package com.tao.swordoffer;

import com.tao.common.TreeNode;

import java.util.*;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p>从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * </p>
 * @solution: 使用队列，先进先出，根节点入队列，出队列，压入左节点，右节点，弹出左节点，右节点
 **/
public class TreeLevel {

    private static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        return Optional.ofNullable(root).map(node -> {
            ArrayList<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                result.add(current.val);
                Optional.ofNullable(current.left).ifPresent(queue::add);
                Optional.ofNullable(current.right).ifPresent(queue::add);
            }
            return result;
        }).orElse(new ArrayList<>());

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode leftChild1 = new TreeNode(8);
        TreeNode rightChild1 = new TreeNode(13);
        TreeNode leftChild11 = new TreeNode(7);
        TreeNode rightChild12 = new TreeNode(9);
        TreeNode leftChild21 = new TreeNode(11);
        TreeNode rightChild22 = new TreeNode(14);
        root.left = leftChild1;
        root.right = rightChild1;
        leftChild1.left = leftChild11;
        leftChild1.right = rightChild12;
        rightChild1.left = leftChild21;
        rightChild1.right = rightChild22;

        ArrayList<Integer> list = printFromTopToBottom(root);
        System.out.println(list);
    }
}
