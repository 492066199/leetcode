package com.sailing.leetcode.solution382;


import com.sailing.leetcode.other.ListNode;
import java.util.Random;

/***
 * @author sailingYang
 * @date   2019-12-21
 */
public class Solution {

    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        float f = new Random().nextFloat();
        ListNode quick = head;
        ListNode slow = head;
        if(quick == null){
            return 0;
        }

        int count = 1;
        int count_slow = 1;
        while (quick != null){
            int cur = (int)(count * f) + 1;

            while (cur > count_slow){
                slow = slow.next;
                count_slow ++;
            }
            count ++;
            quick = quick.next;
        }

        return slow.val;
    }



    public static void main(String[] args) {
        float f = new Random().nextFloat();
        System.out.println(f);
    }
}
