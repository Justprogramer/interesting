package com.tao.swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p>输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * </p>
 * @solution: 1.在旧表中复制节点 A->B->C===>A->A'->B->B'->C->C'
 * 2.将旧表中的random关系复制到新的节点上
 * 3.将新旧节点拆分开
 **/
public class RandomListClone {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    private static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //复制
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode cloneHead = new RandomListNode(head.label);
            cloneHead.next = head.next;
            head.next = cloneHead;
            head = cloneHead.next;
        }
        // 复制random
        head = pHead;
        while (head != null) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }
        // 拆分新旧节点
        head = pHead;
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode node = head.next;
            head.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            head = head.next;
        }
        return newHead;
    }
}
