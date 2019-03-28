package com.tao.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/3/22
 * @description: <p>输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 * </p>
 * @solution: 使用堆，堆是先进后出的数据结构或者使用多个指针，断开反转
 **/


public class LinkedListReverse {
    /**
     * 使用堆解决
     *
     * @param listNode rootNode
     * @return result
     */
    private static ArrayList<Integer> printListFromTailToHeadStack(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(listNode);
        ListNode next = listNode.next;
        while (next != null) {
            stack.push(next);
            next = next.next;
        }
        while (!stack.isEmpty()) {
            ListNode currentNode = stack.pop();
            System.out.println(currentNode.val);
            list.add(currentNode.val);
        }
        return list;
    }

    /**
     * 使用指针
     *
     * @param listNode rootNode
     * @return result
     */
    private static ArrayList<Integer> printListFromTailToHeadPointer(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ListNode head = listNode;
        ListNode cur = listNode.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        //此时listNode的next还指向第二个node，所以要让listNode.next=null,防止循环
        listNode.next = null;
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(printListFromTailToHeadStack(listNode1));
        System.out.println(printListFromTailToHeadPointer(listNode1));
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}