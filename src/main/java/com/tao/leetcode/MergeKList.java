package com.tao.leetcode;

import com.tao.common.ListNode;

/**
 * @author: Penger
 * @time: 2019/8/23
 * @description: <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;
        while(true){
            // 指向lists中最小的节点
            ListNode node = null;
            // 最小节点的索引，如果等于lists.length,说明lists已经遍历完
            int index = lists.length;
            //遍历list,每次取最小的一个节点并记录它的索引
            for(int i = 0; i< lists.length; i++){
                ListNode n = lists[i];
                if(n == null){
                    continue;
                }
                if(node == null){
                    node = n;
                    index = i;
                }else{
                    if(node.val > n.val){
                        node = n;
                        index = i;
                    }
                }
            }
            if(index == lists.length){
                break;
            }
            // 取到最小节点后更新它为下一位节点
            lists[index] = node.next;
            if (head == null){
                head = node;
            }else{
                cur.next = node;
            }
            cur = node;
            cur.next = null;
        }
        return head;
    }
}
