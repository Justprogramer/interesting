package com.tao.leetcode;

import com.tao.common.TreeNode;

import java.util.Optional;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>检查一棵树是否是二叉排序树
 * </p>
 * @solution: <p>
 * 将当前节点与左节点的最大值比较，如果大于说明当前节点左边符合二叉排序树的定义；
 * 将当前节点与右节点的最小值比较，如果小于说明当前节点右边符合二叉排序树的定义；
 * 递归判断当前节点的左孩子和右孩子是否符合二叉排序树的定义；
 * </p>
 **/
public class CheckBST {
    private  boolean isValidBST(TreeNode root){
        return Optional.ofNullable(root).map(node -> {
            TreeNode left = node.left;
            // node 大于 左节点的最大值
            while (left != null) {
                if (left.val >= node.val) {
                    return false;
                }
                left = left.right;
            }
            // node 小于 右节点的最小值
            TreeNode right = node.right;
            while (right != null) {
                if (right.val <= node.val) {
                    return false;
                }
                right = right.left;
            }
            return isValidBST(node.left) && isValidBST(node.right);
        }).orElse(true);
    }
}
