package swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>操作给定的二叉树，将其变换为源二叉树的镜像。
 * </p>
 * @solution: 使用递归，遍历所有节点，如果有子节点，就将子节点对换
 **/
public class MirrorTree {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static void mirror(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null || tree.right != null) {
            TreeNode temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        }
        if (tree.left != null) {
            mirror(tree.left);
        }
        if (tree.right != null) {
            mirror(tree.right);
        }
    }

    public static void main(String[] args) {
        MirrorTree treeDemo = new MirrorTree();
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
        System.out.println(root.val);
        mirror(root);
        System.out.println(root.val);
    }
}
