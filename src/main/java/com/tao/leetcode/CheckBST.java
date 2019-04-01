package com.tao.leetcode;

import com.tao.common.TreeNode;
import org.junit.Test;

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
    private boolean isValidBST(TreeNode root) {
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

    private boolean isValidBSTTwo(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode current, TreeNode min, TreeNode max) {
        if (current == null) {
            return true;
        }
        if (min != null && current.val <= min.val) {
            return false;
        }
        if (max != null && current.val >= max.val) {
            return false;
        }
        return isValidBST(current.left, min, current) && isValidBST(current.right, current, max);
    }

    private boolean isValidBSTThree(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        return root == null
                || root.val < maxVal && root.val > minVal
                && isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(15);
        TreeNode rrl = new TreeNode(6);
        TreeNode rrr = new TreeNode(20);
        root.left = rl;
        root.right = rr;
        rr.left = rrl;
        rr.right = rrr;
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTTwo(root));
        System.out.println(isValidBSTThree(root));
    }
}
