package com.tao.common;

import lombok.Data;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>
 * </p>
 **/
@Data
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    // parent node
    public TreeLinkNode next;

    public TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode getTree() {
        TreeLinkNode root = new TreeLinkNode(10);
        TreeLinkNode leftChild1 = new TreeLinkNode(8);
        TreeLinkNode rightChild1 = new TreeLinkNode(13);
        TreeLinkNode leftChild11 = new TreeLinkNode(7);
        TreeLinkNode rightChild12 = new TreeLinkNode(9);
        TreeLinkNode leftChild21 = new TreeLinkNode(11);
        TreeLinkNode rightChild22 = new TreeLinkNode(14);
        root.left = leftChild1;
        root.right = rightChild1;
        leftChild1.left = leftChild11;
        leftChild1.right = rightChild12;
        rightChild1.left = leftChild21;
        rightChild1.right = rightChild22;
        return root;
    }
}
