package com.sailing.leetcode.solution203;

import com.sailing.leetcode.other.ListNode;


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        while (head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode q = head;
        ListNode p = q.next;
        while (p != null){
            if(p.val == val){
                q.next = p.next;
                p.next = null;
                p = q.next;
            }else {
                q = p;
                p = p.next;
            }
        }

        return head;
    }
}
