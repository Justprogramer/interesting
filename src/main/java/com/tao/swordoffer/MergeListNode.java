package com.tao.swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * </p>
 * @solution: 新建一个链表用来保存list1和list2比较中小的那个节点
 **/
public class MergeListNode {
    private static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode mergeHead;
        if (list1.val <= list2.val) {
            mergeHead = list1;
            mergeHead.next = merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = merge(list1, list2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);
        listNode2.next.next.next.next.next = new ListNode(6);
        ListNode node = merge(listNode1, listNode2);
        while (node.next != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }
}
