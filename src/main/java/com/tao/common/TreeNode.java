package com.tao.common;

import lombok.Data;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>
 * </p>
 **/
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
