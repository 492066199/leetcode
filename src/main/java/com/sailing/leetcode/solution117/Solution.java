package com.sailing.leetcode.solution117;

import com.sailing.leetcode.other.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        connect(left);
        connect(right);

        while (left != null && right != null){
            TreeLinkNode p = left;

            while (p.next != null){
                p = p.next;
            }

            TreeLinkNode q = right;

            left = findNextHop(left);
            right = findNextHop(right);

            //connect
            p.next = q;
        }
    }

    private TreeLinkNode findNextHop(TreeLinkNode cur) {
        if(cur == null){
            return null;
        }

        if(cur.left != null){
            return cur.left;
        }

        if(cur.right != null){
            return cur.right;
        }

        return findNextHop(cur.next);
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(2);
        root.left = new TreeLinkNode(5);
        root.right = new TreeLinkNode(7);

        new Solution().connect(root);
    }
}
