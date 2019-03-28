package com.tao.swordoffer;

import java.util.ArrayList;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p>输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * </p>
 * @solution: 使用递归的思想，从根节点往下遍历，将目标值减去当前节点值，如果当前节点为叶子节点而且目标值为0，说明找到一条路径，将其保存，
 * 否则往上一级，查找另一条路径是否存在满足的路径
 **/
public class TreePathSum {

    private static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPath(root, target, result, temp);
        return result;
    }

    private static void findPath(TreeNode node, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        target -= node.val;
        if (target == 0 && node.right == null && node.left == null) {
            result.add(new ArrayList<>(temp));
        } else {
            findPath(node.left, target, result, temp);
            findPath(node.right, target, result, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNodel = new TreeNode(5);
        TreeNode treeNoder = new TreeNode(12);
        TreeNode treeNodell = new TreeNode(4);
        TreeNode treeNodelr = new TreeNode(7);
        treeNode.left = treeNodel;
        treeNodel.left = treeNodell;
        treeNode.right = treeNoder;
        treeNodel.right = treeNodelr;
        System.out.println(findPath(treeNode, 22));
        System.out.println(findPath(treeNode, 21));
    }
}
