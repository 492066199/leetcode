package com.sailing.leetcode.solution160;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int countA = 0;
        ListNode p = headA;
        while (p != null){
            countA ++;
            p = p.next;
        }

        int countB = 0;
        p = headB;
        while (p != null){
            countB ++;
            p = p.next;
        }

        ListNode plong = headA;
        ListNode pshort = headB;
        int diff = countA - countB;
        if(countB > countA){
            plong = headB;
            pshort = headA;
            diff = countB - countA;
        }

        while (diff > 0){
            plong = plong.next;
            diff --;
        }

        while (plong != pshort){
            plong = plong.next;
            pshort = pshort.next;

            if(plong == null || pshort == null){
                return null;
            }
        }

        return plong;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
