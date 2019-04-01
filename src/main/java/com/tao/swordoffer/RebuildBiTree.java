package com.tao.swordoffer;

import com.tao.common.TreeNode;

import java.util.Optional;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 * </p>
 * @solution: 前序遍历的第一个节点就是树的根节点，所以我们先根据前序遍历序列的第一个数字创建根结点，
 * 接下来在中序遍历序列中找到根结点的位置，根节点的左边就是左子树，右边就是右子树，这样就能确定左、右子树结点的数量。
 * 在前序遍历和中序遍历的序列中划分了左、右子树结点的值之后，就可以递归地去分别构建它的左右子树。
 **/
public class RebuildBiTree {
    private static TreeNode rebuildBiTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return rebuildBiTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 一颗子树在前序遍历的起始位置和结束位置，在中序遍历的起始位和结束位
     *
     * @param pre      前序遍历数组
     * @param preStart 前序遍历的起始位置
     * @param preEnd   前序遍历的结束位置
     * @param in       中序遍历数组
     * @param inStart  序遍历的起始位
     * @param inEnd    序遍历的结束位
     * @return 子树的根节点
     */
    private static TreeNode rebuildBiTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i < in.length; i++) {
            if (in[i] == pre[preStart]) {
                root.left = rebuildBiTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = rebuildBiTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 2, 7, 1, 5, 3, 8, 6};
        TreeNode root = rebuildBiTree(pre, in);
        Optional.ofNullable(root).ifPresent(r -> System.out.println(r.val));
    }
}
