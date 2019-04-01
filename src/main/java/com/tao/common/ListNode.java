package com.tao.common;

import lombok.Data;

/**
 * @author: Penger
 * @time: 2019/4/1
 * @description: <p>
 * </p>
 **/
@Data
public class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
}
