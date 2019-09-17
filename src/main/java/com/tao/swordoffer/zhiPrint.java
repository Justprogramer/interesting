package com.tao.swordoffer;

import com.tao.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/9/17
 * @description: <p>
 * </p>
 **/
public class zhiPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 奇数行存放，入栈应该从右往左
        Stack<TreeNode> stackEven = new Stack<>();
        // 偶数行存放， 入栈应该由左往右
        Stack<TreeNode> stackOdd = new Stack<>();
        if (pRoot == null) {
            return res;
        }
        // 第一行属于奇数，所以入odd栈
        stackOdd.add(pRoot);
        // 从第一行开始，所以一开始even应该为false
        boolean even = false;
        while (!stackEven.isEmpty() || !stackOdd.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (!even) {
                // 奇数行打印，同时其子节点入偶数栈，由左往右
                while (!stackOdd.isEmpty()) {
                    TreeNode n = stackOdd.pop();
                    temp.add(n.val);
                    if (n.left != null) {
                        stackEven.add(n.left);
                    }
                    if (n.right != null) {
                        stackEven.add(n.right);
                    }
                }
            } else {
                // 偶数行打印，同时其子节点入奇数栈，由右往左
                while (!stackEven.isEmpty()) {
                    TreeNode n = stackEven.pop();
                    temp.add(n.val);
                    if (n.right != null) {
                        stackOdd.add(n.right);
                    }
                    if (n.left != null) {
                        stackOdd.add(n.left);
                    }

                }
            }
            // 每次遍历当前行，变换even为相反值
            even = !even;
            res.add(temp);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.getTree();
        Print(node);
    }

}
