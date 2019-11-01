package com.sailing.leetcode.solution138;

import com.sailing.leetcode.other.RandomListNode;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }

        //insert node
        RandomListNode p = head;
        while (p != null){
            RandomListNode newP = new RandomListNode(p.label);
            newP.random = p.random;
            newP.next = p.next;

            p.next = newP;

            p = newP.next;
        }

        //change random
        p = head.next;
        while (p != null){
            if(p.random != null){
                p.random = p.random.next;
            }
            if(p.next == null){
                break;
            }
            p = p.next;
            p = p.next;
        }

        //change next
        p = head;
        RandomListNode bakHead = head.next;
        RandomListNode p2 = bakHead;
        while (p != null){
            p.next = p2.next;
            p = p.next;
            if(p2.next == null){
                break;
            }else {
                p2.next = p2.next.next;
                p2 = p2.next;
            }
        }

        return bakHead;
    }
}
