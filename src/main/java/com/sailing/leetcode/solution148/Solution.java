package com.sailing.leetcode.solution148;


public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        head = quicksort(head);

        return head;
    }

    private ListNode quicksort(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode keyLast = head;
        ListNode keyFirst = head;

        ListNode origin = head.next;
        head.next = null;

        ListNode biggerList = null;
        ListNode smallList = null;


        while (origin != null){
            ListNode tmpP = origin.next;
            if(origin.val > keyLast.val){
                origin.next = biggerList;
                biggerList = origin;
            }else if(origin.val < keyLast.val){
                origin.next = smallList;
                smallList = origin;
            }else {
                origin.next = keyFirst;
                keyFirst = origin;
            }
            origin = tmpP;
        }


        if(biggerList != null) {
            ListNode mergeRight = quicksort(biggerList);
            keyLast.next = mergeRight;
        }

        if(smallList == null){
            return keyFirst;
        }else {
            ListNode mergeLeft = quicksort(smallList);
            ListNode p = mergeLeft;
            while (p.next != null){
                p = p.next;
            }
            p.next = keyFirst;
            return mergeLeft;
        }
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(new Solution().sortList(a));
    }
}
