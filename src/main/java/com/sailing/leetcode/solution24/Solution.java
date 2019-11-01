package com.sailing.leetcode.solution24;

/**
 * beat 74%
 * yangyang 2018-03-17
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p0 = null;
        ListNode p1 = head;
        if(p1 == null){
            return p1;
        }
        ListNode p2 = head.next;
        if(p2 == null){
            return head;
        }

        ListNode newhead = p2;

        ListNode p3 = null;
        ListNode p4 = null;
        ListNode p5 = null;
        while (p1 != null && p2 != null){
            p4 = p2.next;
            if(p4 == null){
                p5 = null;
            }else {
                p5 = p4.next;
            }

            p3 = swap(p0, p1, p2);

            p0 = p3;
            p1 = p4;
            p2 = p5;
        }
        return newhead;
    }

    private ListNode swap(ListNode p0, ListNode p1, ListNode p2) {
        if(p0 == null){
            p1.next = p2.next;
            p2.next = p1;
            return p1;
        }else {
            p0.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            return p1;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return " " + val +" ";
        }
    }

    public static void main(String[] args) {
        ListNode[] ar = new ListNode[3];
        ar[0] = new ListNode(1);
        ar[1] = new ListNode(2);
        ar[2] = new ListNode(3);
        ar[0].next = ar[1];
        ar[1].next = ar[2];

        System.out.println(new Solution().swapPairs(ar[0]));
    }
}
