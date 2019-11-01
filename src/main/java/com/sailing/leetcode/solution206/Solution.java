package com.sailing.leetcode.solution206;

import java.util.List;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode headOfListNeedAppend = head.next;
        head.next = null;
        ListNode nextOfListNeedAppend = null;
        while (headOfListNeedAppend != null){
            nextOfListNeedAppend = headOfListNeedAppend.next;
            headOfListNeedAppend.next = head;
            head = headOfListNeedAppend;
            headOfListNeedAppend = nextOfListNeedAppend;
        }
        return head;
    }
    
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
