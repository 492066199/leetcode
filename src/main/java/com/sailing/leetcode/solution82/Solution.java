package com.sailing.leetcode.solution82;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode p = head;
        ListNode pre = null;
        boolean r = false;
        while (p.next != null){
            if(p.val == p.next.val){
                r = true;
                //delete p.next
                p.next = p.next.next;
            }else {
                if(r){
                    r = false;
                    if(pre == null){
                        head = p.next;
                        p = head;
                    }else {
                        pre.next = p.next;
                        p = pre.next;
                    }
                }else{
                    pre = p;
                    p = p.next;
                }
            }
        }

        if(r){
            if(pre == null){
                return null;
            }else{
                pre.next = null;
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
