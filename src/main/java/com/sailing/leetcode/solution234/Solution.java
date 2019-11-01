package com.sailing.leetcode.solution234;

import com.sailing.leetcode.other.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        int count = 0;
        ListNode p = head;
        while (p  != null){
            p = p.next;
            count++;
        }

        if(count == 1){
            return true;
        }

        if(count == 2){
            if(head.val == head.next.val){
                return true;
            }else {
                return false;
            }
        }
        ListNode last = checkAndReturnLast(p.next, count - 2);
        if(last == null){
            return false;
        }

        return head.val == last.val;
    }

    private ListNode checkAndReturnLast(ListNode p, int c) {
        if(c == 1){
            return p.next;
        }

        if(c == 2){
            if(p.val == p.next.val){
                return p.next.next;
            }else {
                return null;
            }
        }

        ListNode l = checkAndReturnLast(p.next, c - 2);
        if(l == null){
            return null;
        }

        if(p.val == l.val){
            return l.next;
        }else {
            return null;
        }
    }
}
