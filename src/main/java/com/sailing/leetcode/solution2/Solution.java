package com.sailing.leetcode.solution2;

/**
 * 隐含的难 shit!
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;

        int count1 = 0;
        int count2 = 0;
        while (n1 != null || n2 != null){
            if(n1 != null){
                count1++;
                n1 = n1.next;
            }

            if(n2 != null){
                count2++;
                n2 = n2.next;
            }
        }

        ListNode longNode = l1;
        ListNode shortNode = l2;
        if(count1 < count2){
            longNode = l2;
            shortNode = l1;
        }

        int c = 0;
        ListNode pre = null;
        while (longNode != null || c != 0){
            int sum = 0;
            if(longNode == null){
                ListNode last = new ListNode(1);
                pre.next = last;
                break;
            }else if(shortNode == null){
                sum = c + longNode.val;
            }else{
                sum = longNode.val + shortNode.val + c;
            }

            if(sum < 10){
                c = 0;
                longNode.val = sum;
            }else {
                c = 1;
                longNode.val = sum - 10;
            }
            pre = longNode;
            longNode = longNode.next;
            if(shortNode == null){
                if(c == 0){
                    break;
                }
            }else{
                shortNode = shortNode.next;
            }
        }

        if(count1 < count2){
            return l2;
        }else{
            return l1;
        }
    }

    public static void main(String[] args) {

    }
}
