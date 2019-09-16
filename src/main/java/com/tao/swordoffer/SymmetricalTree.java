package com.tao.swordoffer;

import com.tao.common.TreeNode;

/**
 * @author: Penger
 * @time: 2019/9/16
 * @description: <p>请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 * </p>
 **/
public class SymmetricalTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        // 为空直接返回true
        if (pRoot == null) {
            return true;
        }
        // 比较左右子树是否对称
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        // 左右子树为空直接返回true
        if (left == null && right == null) {
            return true;
        }
        // 左右子树有一个为空，返回false
        if (left == null || right == null) {
            return false;
        }
        // 都不为空则判断，左子树的左子树是否和右子树的右子树相同 以及 左子树的右子树是否和右子树的左子树相同
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);

    }
}
