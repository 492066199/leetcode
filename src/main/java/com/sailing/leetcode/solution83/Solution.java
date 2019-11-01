package com.sailing.leetcode.solution83;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode p = head;
        while (p.next != null){
            if(p.val == p.next.val){
                //delete p.next
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }

        return head;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
