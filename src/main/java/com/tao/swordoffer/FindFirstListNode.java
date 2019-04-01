package com.tao.swordoffer;

import com.tao.common.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>两个链表的第一个公共结点
 * </p>
 * @solution: <p>
 * 如果两个链表存在公共结点，那么它们从公共结点开始一直到链表的结尾都是一样的，
 * 因此我们只需要从链表的结尾开始，往前搜索，找到最后一个相同的结点即可
 * 。但是题目给出的单向链表，我们只能从前向后搜索，这时，我们就可以借助栈来完成。
 * 先把两个链表依次装到两个栈中，然后比较两个栈的栈顶结点是否相同，如果相同则出栈，
 * 如果不同，那最后相同的结点就是我们要的返回值。
 * 还有一种方法，不需要借助栈。先找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走，直到找到第一个公共结点。
 * </p>
 **/
public class FindFirstListNode {
    private ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode f = pHead1, s = pHead2;
        while (f != null) {
            len1++;
            f = f.next;
        }
        while (s != null) {
            len2++;
            s = s.next;
        }
        if (len1 > len2) {
            while (len1 - len2 != 0) {
                pHead1 = pHead1.next;
                len1--;
            }
        } else if (len1 < len2) {
            while (len2 - len1 != 0) {
                pHead2 = pHead2.next;
                len2--;
            }
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public ListNode findFirstCommonNodeTwo(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode res = null;
        while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
            s1.pop();
            res = s2.pop();
        }
        return res;
    }

    @Test
    public void test() {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t11 = new ListNode(11);
        ListNode t12 = new ListNode(12);
        ListNode t13 = new ListNode(13);
        ListNode t14 = new ListNode(14);
        ListNode t15 = new ListNode(15);
        ListNode t6 = new ListNode(6);
        ListNode t7 = new ListNode(7);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t6;
        t6.next = t7;
        t11.next = t12;
        t12.next = t13;
        t13.next = t14;
        t14.next = t15;
        t15.next = t6;
        ListNode firstCommonNode = findFirstCommonNode(t1, t11);
        System.out.println(firstCommonNode.val);
    }

}
