package com.tao.swordoffer;

import com.tao.common.TreeNode;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>操作给定的二叉树，将其变换为源二叉树的镜像。
 * </p>
 * @solution: 使用递归，遍历所有节点，如果有子节点，就将子节点对换
 **/
public class MirrorTree {

    private static void mirror(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null || tree.right != null) {
            TreeNode temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        }
        if (tree.left != null) {
            mirror(tree.left);
        }
        if (tree.right != null) {
            mirror(tree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(root.val);
        mirror(root);
        System.out.println(root.val);
    }
}
