package com.tao.swordoffer;

import com.tao.common.TreeNode;

import java.util.Optional;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>判断一棵树是否是二叉平衡树
 * </p>
 * @solution: 使用递归判断左右子树是否是二叉平衡树，已经左右子树的高度相差小于1
 **/
public class CheckBalanceTree {

    private boolean isBalanceTree(TreeNode root) {
        return Optional.ofNullable(root).map(r -> {
            int left = treeDepth(r.left);
            int right = treeDepth(r.right);
            return Math.abs(left - right) <= 1
                    && isBalanceTree(r.left)
                    && isBalanceTree(r.right);
        }).orElse(true);
    }

    private int treeDepth(TreeNode root) {
        return Optional.ofNullable(root).map(r -> {
            int left = treeDepth(r.left);
            int right = treeDepth(r.right);
            return Math.max(left, right) + 1;
        }).orElse(0);
    }
}
