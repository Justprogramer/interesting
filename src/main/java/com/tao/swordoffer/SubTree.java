package com.tao.swordoffer;

import com.tao.common.TreeNode;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>输入两棵二叉树A，B，判断B是不是A的子结构。ps：我们约定空树不是任意一个树的子结构
 * </p>
 * @solution: 递归思想，如果根节点相同则递归调用IsSubtree()，
 * 如果根节点不相同，则判断root1的左子树和root2是否相同，再判断右子树和root2是否相同;
 **/
public class SubTree {

    private static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        return root1 != null
                && root2 != null
                && (isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2));
    }

    private static boolean isSubtree(TreeNode root1, TreeNode root2) {
        return root2 == null
                || (root1 != null
                && root1.val == root2.val
                && isSubtree(root1.left, root2.left)
                && isSubtree(root1.right, root2.right));
    }
}
