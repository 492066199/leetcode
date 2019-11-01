package com.sailing.leetcode.solution236;

import com.sailing.leetcode.other.TreeNode;

import java.util.LinkedList;


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> r = new LinkedList<>();
        findPath(root, p, r);

        if(findq(p.left, q) || findq(p.right, q)){
            return p;
        }else {
            TreeNode before = p;
            while (r.size() > 1){
               TreeNode t = r.removeLast();
               if(t.val == q.val){
                   return t;
               }

               if(before == t.left){
                   if(findq(t.right, q)){
                       return t;
                   }
               }else {
                   if(findq(t.left, q)){
                       return t;
                   }
               }
               before = t;
            }
        }

        return root;
    }

    private boolean findq(TreeNode root, TreeNode q) {
        if(root == null){
            return false;
        }

        if(root.val == q.val){
            return true;
        }

        return findq(root.left, q) || findq(root.right, q);

    }

    private boolean findPath(TreeNode r, TreeNode p, LinkedList<TreeNode> path) {
        if(r == null){
            return false;
        }
        if(r.val == p.val){
           return true;
        }

        path.addLast(r);
        //left
        boolean e = findPath(r.left, p, path);
        if(e){
            return true;
        }
        //right
        e = findPath(r.right, p, path);
        if(e){
            return true;
        }

        path.removeLast();

        return false;
    }
}
