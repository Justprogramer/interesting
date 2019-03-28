package com.tao.swordoffer;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p>将二叉排序树转成双向有序链表，要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * </p>
 * @solution: 二叉树的中序遍历就是有序的，使用队列存储遍历的节点，再调整他的指针
 **/
public class BiSortTreeToBiListNode {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 使用队列实现
     */
    private static TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        midOrder(pRootOfTree, queue);
        TreeNode root = queue.poll();
        TreeNode pre = root;
        pre.left = null;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            current.left = pre;
            pre.right = current;
            pre = current;
        }
        pre.right = null;
        return root;
    }

    private static void midOrder(TreeNode node, Queue<TreeNode> queue) {
        Optional.ofNullable(node).ifPresent(n -> {
            midOrder(n.left, queue);
            queue.add(n);
            midOrder(n.right, queue);
        });
    }

    public static void main(String[] args) {
        BiSortTreeToBiListNode treeDemo = new BiSortTreeToBiListNode();
        TreeNode root = treeDemo.new TreeNode(10);
        TreeNode leftChild1 = treeDemo.new TreeNode(8);
        TreeNode rightChild1 = treeDemo.new TreeNode(13);
        TreeNode leftChild11 = treeDemo.new TreeNode(7);
        TreeNode rightChild12 = treeDemo.new TreeNode(9);
        TreeNode leftChild21 = treeDemo.new TreeNode(11);
        TreeNode rightChild22 = treeDemo.new TreeNode(14);
        root.left = leftChild1;
        root.right = rightChild1;
        leftChild1.left = leftChild11;
        leftChild1.right = rightChild12;
        rightChild1.left = leftChild21;
        rightChild1.right = rightChild22;
        TreeNode convertNode = convert(root);
        while (convertNode != null) {
            System.out.print(convertNode.val + " ");
            convertNode = convertNode.right;
        }
    }
}
