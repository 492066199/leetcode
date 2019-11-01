package com.sailing.leetcode.solution147;

import com.sailing.leetcode.other.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead= head;
        ListNode reamin = head.next;

        newHead.next = null;
        ListNode tmp = null;

        while (reamin != null){
            tmp = reamin.next;

            reamin.next = null;

            newHead = insert(reamin, newHead);

            reamin = tmp;
        }

        return newHead;
    }

    private ListNode insert(ListNode node, ListNode newHead) {
        if(node.val <= newHead.val){
            node.next = newHead;
            newHead = node;
            return newHead;
        }

        ListNode p = newHead;
        while (node.val > p.val){
            if(p.next == null){
                p.next = node;
                return newHead;
            }else {
                if(node.val <= p.next.val) {
                    node.next = p.next;
                    p.next = node;
                    return newHead;
                    //node > p.next
                }else {
                    p = p.next;
                }
            }
        }

        return newHead;
    }
}
