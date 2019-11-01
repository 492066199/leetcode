package com.sailing.leetcode.solution109;

import com.sailing.leetcode.other.ListNode;
import com.sailing.leetcode.other.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int count = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            count ++;
        }

        Object[] r = listToTree(head, count);

        return (TreeNode) r[0];
    }

    private Object[] listToTree(ListNode head, int count) {
        Object[] r = new Object[2];
        if(count <= 0){
            return r;
        }

        if(count == 1){
            r[0] = new TreeNode(head.val);
            r[1] = head.next;
            return r;
        }


        //count must >= 2
        int mid = count / 2;

        //left
        Object[] rLeft = listToTree(head, mid);
        ListNode next = (ListNode) rLeft[1];
        TreeNode left = (TreeNode) rLeft[0];

        //mid
        TreeNode root = new TreeNode(next.val);
        root.left = left;


        int remain = count - mid - 1;
        if(remain > 0) {
            //right
            Object[] rRight = listToTree(next.next, remain);
            TreeNode right = (TreeNode) rRight[0];
            next = (ListNode) rRight[1];
            root.right = right;
            r[1] = next;
        }else {
            root.right = null;
            r[1] = next.next;
        }

        r[0] = root;
        return r;
    }
}
