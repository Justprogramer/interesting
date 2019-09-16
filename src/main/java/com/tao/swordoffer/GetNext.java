package com.tao.swordoffer;

import com.tao.common.TreeLinkNode;

/**
 * @author: Penger
 * @time: 2019/9/16
 * @description: <p>给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * </p>
 **/
public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        //为空直接返回空
        if (pNode == null) {
            return null;
        }
        // 存在右子树，则选取右子树最左下的节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        // 不存在右子树，但是存在父节点
        while (pNode.next != null) {
            // 如果当前节点是父节的左子树，说明下个节点就是他的父节点，因为它不存在右子树
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) {
                return parent;
            }
            // 如果当前节点不是父节点的左子树，说明该节点是父节点的最右边，位于一个左子树中，中序遍历的下一个节点可能是该左子树的父节点
            pNode = parent;
        }
        return null;
    }
}
