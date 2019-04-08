package com.tao.common;

import lombok.Data;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>
 * </p>
 **/
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTree() {
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
        return root;
    }
}
