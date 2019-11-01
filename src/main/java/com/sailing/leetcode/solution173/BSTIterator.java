package com.sailing.leetcode.solution173;

import com.sailing.leetcode.other.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    private TreeNode cur;
    private LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.cur = root;
        while (cur != null){
            stack.addLast(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        if(cur == null){
            TreeNode bak = stack.removeLast();
            cur = bak.right;
            while (cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            return bak.val;
        }else {
            return cur.val;
        }
    }

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
    public static void main(String[] args) {

        BSTIterator i = new BSTIterator(null);
        while (i.hasNext()) {
            i.next();
        }
    }
}
