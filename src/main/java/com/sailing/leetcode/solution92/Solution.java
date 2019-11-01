package com.sailing.leetcode.solution92;

import com.sailing.leetcode.other.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }

        if(m == n){
            return head;
        }

        ListNode pm = null;
        ListNode mm = head;
        if(m != 1){
            int c = m;
            pm = head;
            while (c > 2) {
                pm = pm.next;
                c --;
            }
            mm = pm.next;
        }
        int count = n - m;
        ListNode start = mm.next;

        mm.next = null;
        while (count > 0){
            ListNode tmp = start.next;
            if(pm == null){
                start.next = head;
                head = start;
            }else {
                start.next = pm.next;
                pm.next = start;
            }

            if(count == 1){
                mm.next = tmp;
                break;
            }else {
                start = tmp;
            }
            count--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new Solution().reverseBetween(a, 2, 4);
    }
}
