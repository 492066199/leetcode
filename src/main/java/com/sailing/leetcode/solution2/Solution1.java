package com.sailing.leetcode.solution2;

/**
 * beat 80%
 * yangyang 2018-03-17
 * 终于有点成就感了
 */
public class Solution1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;


        int c = 0;
        ListNode pre = null;
        while (n1 != null || n2 != null || c != 0){
            int sum = 0;
            if(n1 == null && n2 == null){
                ListNode last = new ListNode(1);
                pre.next = last;
                break;
            }else if(n1 == null) {
                pre.next = n2;
                n1 = n2;
                n2 = null;
            }

            sum = c + n1.val + (n2 == null ? 0 : n2.val);

            n1.val = sum % 10;
            c = sum / 10;

            pre = n1;
            n1 = n1.next;
            if(n2 == null){
                if(c == 0){
                    break;
                }
            }else{
                n2 = n2.next;
            }
        }

        return l1;
    }
}
