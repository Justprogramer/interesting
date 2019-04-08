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
        TreeNode root = TreeNode.getTree();

        ArrayList<Integer> list = printFromTopToBottom(root);
        System.out.println(list);
    }
}
