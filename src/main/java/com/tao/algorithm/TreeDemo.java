package com.tao.algorithm;

import lombok.Data;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;

/**
 * author: TAOPENG
 * time ： 2019/3/11
 **/
@Data
public class TreeDemo {
    @Data
    public class TreeNode {
        private Integer value;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }

    public void preOrder(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            System.out.print(n.getValue() + " ");
            preOrder(n.getLeftChild());
            preOrder(n.getRightChild());
        });
    }

    // 先序遍历非递归实现
    public void preOrder2(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            Stack<TreeNode> stack = new Stack<>();
            while (n != null || !stack.isEmpty()) {
                while (n != null) {
                    System.out.print(n.getValue() + " ");
                    stack.push(n);
                    n = n.getLeftChild();
                }
                if (!stack.isEmpty()) {
                    n = stack.pop().getRightChild();
                }
            }
        });

    }

    public void midOrder(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            midOrder(n.getLeftChild());
            System.out.print(n.getValue() + " ");
            midOrder(n.getRightChild());
        });
    }

    // 中序遍历非递归实现
    public void midOrder2(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            Stack<TreeNode> stack = new Stack<>();
            while (n != null || !stack.isEmpty()) {
                while (n != null) {
                    stack.push(n);
                    n = n.getLeftChild();
                }
                if (!stack.isEmpty()) {
                    TreeNode child = stack.pop();
                    System.out.print(child.getValue() + " ");
                    n = child.getRightChild();
                }
            }
        });

    }

    public void postOrder(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            postOrder(n.getLeftChild());
            postOrder(n.getRightChild());
            System.out.print(n.getValue() + " ");
        });
    }
    // 后序遍历非递归实现
    public void postOrder2(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            Stack<TreeNode> s = new Stack<>();

            TreeNode curNode = n; //当前访问的结点
            TreeNode lastVisitNode = null; //上次访问的结点
            //把currentNode移到左子树的最下边
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.getLeftChild();
            }
            while (!s.empty()) {
                curNode = s.pop();  //弹出栈顶元素
                //一个根节点被访问的前提是：无右子树或右子树已被访问过
                if (curNode.getRightChild() != null && curNode.getRightChild() != lastVisitNode) {
                    //根节点再次入栈
                    s.push(curNode);
                    //进入右子树，且可肯定右子树一定不为空
                    curNode = curNode.getRightChild();
                    while (curNode != null) {
                        //再走到右子树的最左边
                        s.push(curNode);
                        curNode = curNode.getLeftChild();
                    }
                } else {
                    //访问
                    System.out.print(curNode.getValue() + " ");
                    //修改最近被访问的节点
                    lastVisitNode = curNode;
                }
            }
        });

    }

    public void levelOrder(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            linkedList.add(n);
            while (!linkedList.isEmpty()) {
                TreeNode current = linkedList.poll();
                System.out.print(current.getValue() + " ");
                Optional.ofNullable(current.getLeftChild()).ifPresent(linkedList::add);
                Optional.ofNullable(current.getRightChild()).ifPresent(linkedList::add);
            }
        });
    }

    public void dfs(TreeNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(n);
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                System.out.print(current.getValue() + " ");
                Optional.ofNullable(current.getRightChild()).ifPresent(stack::add);
                Optional.ofNullable(current.getLeftChild()).ifPresent(stack::add);
            }
        });
    }

    public Integer getHeight(TreeNode node) {
        return Optional.ofNullable(node).map(n -> {
            int leftHeight = getHeight(n.getLeftChild());
            int rightHeight = getHeight(n.getRightChild());
            return Math.max(leftHeight, rightHeight) + 1;
        }).orElse(0);
    }

    public Integer getMax(TreeNode node) {
        return Optional.ofNullable(node).map(n -> {
            int leftMax = getMax(n.getLeftChild());
            int rightMax = getMax(n.getRightChild());
            return Math.max(n.getValue(), Math.max(leftMax, rightMax));
        }).orElse(Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        TreeDemo treeDemo = new TreeDemo();
        TreeNode root = treeDemo.new TreeNode(10);
        TreeNode leftChild1 = treeDemo.new TreeNode(8);
        TreeNode rightChild1 = treeDemo.new TreeNode(13);
        TreeNode leftChild11 = treeDemo.new TreeNode(7);
        TreeNode rightChild12 = treeDemo.new TreeNode(9);
        TreeNode leftChild21 = treeDemo.new TreeNode(11);
        TreeNode rightChild22 = treeDemo.new TreeNode(14);
        root.setLeftChild(leftChild1);
        root.setRightChild(rightChild1);
        leftChild1.setLeftChild(leftChild11);
        leftChild1.setRightChild(rightChild12);
        rightChild1.setLeftChild(leftChild21);
        rightChild1.setRightChild(rightChild22);
        System.out.print("preOrder:");
        treeDemo.preOrder(root);
        System.out.println();
        System.out.print("preOrder2:");
        treeDemo.preOrder2(root);
        System.out.println();
        System.out.print("midOrder:");
        treeDemo.midOrder(root);
        System.out.println();
        System.out.print("midOrder2:");
        treeDemo.midOrder2(root);
        System.out.println();
        System.out.print("postOrder:");
        treeDemo.postOrder(root);
        System.out.println();
        System.out.print("postOrder2:");
        treeDemo.postOrder2(root);
        System.out.println();
        System.out.print("levelOrder:");
        treeDemo.levelOrder(root);
        System.out.println();
        System.out.print("DFS:");
        treeDemo.dfs(root);
        System.out.println();
        System.out.print("Height:" + treeDemo.getHeight(root));
        System.out.println();
        System.out.print("Max:" + treeDemo.getMax(root));
    }
}
