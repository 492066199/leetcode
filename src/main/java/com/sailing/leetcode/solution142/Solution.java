package com.sailing.leetcode.solution142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (true){
            if(p1 == null){
                return null;
            }else {
                p1 = p1.next;
            }

            if(p2 == null){
                return null;
            }else {
                p2 = p2.next;
                if(p2 == null){
                    return null;
                }
                p2 = p2.next;
            }
            if(p1 == p2 && p1 != null){
                break;
            }
        }

        int count = 1;
        p1 = p1.next;

        while (p1 != p2){
            count ++;
            p1 = p1.next;
        }

        //投入指针
        p1 = head;
        while (count != 0){
            p1 = p1.next;
            count --;
        }

        p2 = head;

        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
    
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}