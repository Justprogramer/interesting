package com.tao.swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>输入一个链表，输出该链表中倒数第k个结点
 * </p>
 * @solution: 经典的双指针法。
 * 定义两个指针，第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动，
 * 从第k步开始，第二个指针也开始从链表的头指针开始遍历，由于两个指针的距离保持在k-1，
 * 当第一个指针到达链表的尾节点时，第二个指针刚好指向倒数第k个节点。
 **/
public class KthLinkedNode {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        }
        ListNode current = head;
        k--;
        while (k != 0 && current != null) {
            current = current.next;
            k--;
        }
        if (k == 0 && current != null) {
            ListNode pre = head;
            while (current.next != null) {
                current = current.next;
                pre = pre.next;
            }
            return pre;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = FindKthToTail(listNode, 5);
        System.out.println(listNode1 == null ? "" : listNode1.val);
    }

}