package com.tao.swordoffer;

import com.tao.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Penger
 * @time: 2019/4/8
 * @description: <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * </p>
 * @solution: <p>
 * 使用树的前序遍历和中序遍历来重建一颗二叉树
 * </p>
 **/
@Slf4j
public class TreeSerializer {
    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        midOrder(root, sb);
        sb.append(",");
        preOrder(root, sb);
        return sb.toString();
    }

    private TreeNode deserialize(String str) {
        String[] temps = str.split(",");
        if (temps.length != 2) {
            return null;
        }
        List<Integer> midOrders = Arrays.stream(temps[0].split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> preOrders = Arrays.stream(temps[1].split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        return parse(0, midOrders.size() - 1, 0, preOrders.size() - 1, midOrders, preOrders);
    }

    private void midOrder(TreeNode node, StringBuilder sb) {
        Optional.ofNullable(node).ifPresent(n -> {
            midOrder(n.left, sb);
            sb.append(n.val).append(" ");
            midOrder(n.right, sb);
        });
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        Optional.ofNullable(node).ifPresent(n -> {
            sb.append(n.val).append(" ");
            preOrder(n.left, sb);
            preOrder(n.right, sb);
        });
    }

    private TreeNode parse(int midBegin, int midEnd, int preBegin, int preEnd, List<Integer> midOrders, List<Integer> preOrders) {
        if (midBegin > midEnd || preBegin > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preOrders.get(preBegin));
        for (int i = midBegin; i <= midEnd; i++) {
            if (midOrders.get(i) == node.val) {
                node.left = parse(midBegin, i - 1, preBegin + 1, preBegin + i - midBegin, midOrders, preOrders);
                node.right = parse(i + 1, midEnd, preBegin + i - midBegin + 1, preEnd, midOrders, preOrders);
                break;
            }
        }
        return node;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.getTree();
        String str = serialize(root);
        log.info("tree to str:{}", str);
        TreeNode node = deserialize(str);
        log.info("str to tree:{}", node == null ? "" : node.val);
    }

}
