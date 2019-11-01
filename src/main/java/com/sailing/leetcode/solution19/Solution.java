package com.sailing.leetcode.solution19;


public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int c = 0;
        while(pre != null){
            c ++;
            pre = pre.next;
        }

        if(c <  n){
            return head;
        }
        int index = c - n;

        pre = null;
        ListNode cur = head;
        int tick = 0;
        while (tick < index){
            pre = cur;
            cur = cur.next;
        }

        //delete
        if(pre == null){
            return cur.next;
        }else {
            pre.next = cur.next;
            return head;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
