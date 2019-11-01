package com.sailing.leetcode.solution143;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //count node num
        int count = 1;

        ListNode p = head.next;
        while (p != null){
            count++;
            p = p.next;
        }


        //find right list head
        int half = count / 2;
        int fistRemain = count - half;

        ListNode rightHead = head;
        while (fistRemain > 1){
            rightHead = rightHead.next;
            fistRemain --;
        }

        //left list last node next must be null
        ListNode tmp1 = rightHead.next;
        rightHead.next = null;
        rightHead = tmp1;

        //reverse
        ListNode rightRemainList = rightHead.next;
        rightHead.next = null;

        while (rightRemainList != null){
            //save
            ListNode tmp = rightRemainList.next;

            rightRemainList.next = rightHead;
            rightHead = rightRemainList;

            //reload
            rightRemainList = tmp;
        }

        //insert to left
        ListNode leftHead = head;
        while (rightHead != null){
            //save
            ListNode tmp = rightHead.next;

            //insert
            rightHead.next = leftHead.next;
            leftHead.next = rightHead;

            //move left
            leftHead = rightHead.next;

            //reload
            rightHead = tmp;
        }
    }
    
    
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
