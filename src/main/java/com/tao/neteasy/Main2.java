package com.tao.neteasy;

import java.util.*;

/**
 * @author: Penger
 * @time: 2019/9/7
 * @description: <p>
 * </p>
 **/
class TreeNode {
    public Long val;
    Integer leftIndex;
    Integer rightIndex;
    public TreeNode left;
    public TreeNode right;

    TreeNode(Long val, int leftIndex, int rightIndex) {
        this.val = val;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

public class Main2 {

    private static Map<Integer, TreeNode> treeNodes = new HashMap<>();
    private static LinkedList<Integer> rootSets = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            t--;
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                // read treeNode
                long val = scanner.nextLong();
                int leftIndex = scanner.nextInt();
                int rightIndex = scanner.nextInt();
                treeNodes.put(i, new TreeNode(val, leftIndex, rightIndex));
                rootSets.add(i);
            }
            for (Map.Entry<Integer, TreeNode> node : treeNodes.entrySet()) {
                // set child node
                if (node.getValue().leftIndex >= 0) {
                    node.getValue().setLeft(treeNodes.get(node.getValue().leftIndex));
                    rootSets.remove(node.getValue().leftIndex);
                }
                if (node.getValue().rightIndex >= 0) {
                    node.getValue().setRight(treeNodes.get(node.getValue().rightIndex));
                    rootSets.remove(node.getValue().rightIndex);
                }
            }
            TreeNode root;
            if (rootSets.size() == 1) {
                root = treeNodes.get(rootSets.getFirst());
            } else {
                System.out.println("NO");
                continue;
            }
            if (checkTreeNode(root)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    // level order and compare level sum
    private static boolean checkTreeNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        int count = queue.size();
        long parentSum = Long.MIN_VALUE;
        while (!queue.isEmpty()) {
            long childSum = 0;
            while (count > 0 && !queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (n.left != null) {
                    queue.addLast(n.left);
                }
                if (n.right != null) {
                    queue.addLast(n.right);
                }
                count--;
                childSum += n.val;
            }
            if (childSum <= parentSum) {
                return false;
            }
            parentSum = childSum;
            count = queue.size();
        }
        return true;
    }

}
