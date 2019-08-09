package com.tao.leetcode;

import com.tao.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/8/9
 * @description: <p>
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * </p>
 * @solution: <P>
 *
 * </P>
 **/
public class BSTIterator {
    /**
     * 每次返回最小的数，可以按中序遍历二叉搜索树的节点，将节点放入队列中，使用队列来建立迭代器
     */
    private LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.size() != 0;
    }
}

class BSTIteratorTwo {
    /**
     * 保存栈信息，每次直接从栈中取，避免了使用队列
     */
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorTwo(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
