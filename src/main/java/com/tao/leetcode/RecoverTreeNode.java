package com.tao.leetcode;

import com.tao.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Penger
 * @time: 2019/8/16
 * @description: <p>
 * </p>
 **/
@Slf4j
public class RecoverTreeNode {

    public void recoverTree(TreeNode root) {
         if (root == null || root.left == null && root.right == null) {
            return;
        }
        boolean change = false;
        if (root.left != null && root.left.val > root.val) {
            root.val = root.left.val + root.val;
            root.left.val = root.val - root.left.val;
            root.val = root.val - root.left.val;
            change = true;
        }
        if (root.right != null && root.right.val < root.val) {
            root.val = root.right.val + root.val;
            root.right.val = root.val - root.right.val;
            root.val = root.val - root.right.val;
            change = true;
        }
        if (change) {
            recoverTree(root);
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);
        log.info("{}", root.val);
    }
}
