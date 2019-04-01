package com.tao.swordoffer;

import com.tao.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>二叉树的深度
 * </p>
 * @solution: 使用递归或者层次遍历，遍历一层深度+1
 **/
public class TreeDepth {
    private int treeDepth(TreeNode root) {
        return Optional.ofNullable(root).map(r -> {
            int left = treeDepth(r.left);
            int right = treeDepth(r.right);
            return Math.max(left, right) + 1;
        }).orElse(0);
    }

    private int treeDepthStack(TreeNode root) {
        return Optional.ofNullable(root).map(r -> {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(r);
            int deep = 0, start = 0, end = 1;
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();
                start++;
                Optional.ofNullable(head.left).ifPresent(queue::add);
                Optional.ofNullable(head.right).ifPresent(queue::add);
                if (start == end) {
                    end = queue.size();
                    start = 0;
                    deep++;
                }
            }
            return deep;
        }).orElse(0);
    }
}
