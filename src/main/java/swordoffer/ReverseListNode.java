package swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>反转链表
 * </p>
 * @solution: 使用3个指针
 * current为当前节点，pre为当前节点的前一个节点，next为当前节点的下一个节点，
 * 需要pre和next的目的是让当前节点从pre->current->next1->next2变成pre<-current next1->next2的过程中，
 * 用pre让节点反转所指方向，next节点保存next1节点防止链表断开
 **/
public class ReverseListNode {
    private static ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = reverseListNode(listNode);
        System.out.println(listNode1.val);
    }
}
