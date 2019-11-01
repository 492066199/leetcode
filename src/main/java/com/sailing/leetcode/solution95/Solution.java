package com.sailing.leetcode.solution95;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new ArrayList<>();
        }
        List<TreeNode> roots = getTreeListByRange(1, n);
        return roots;
    }

    private List<TreeNode> getTreeListByRange(int start, int end) {
        if(end < start){
            return null;
        }

        if(start == end){
            List<TreeNode> treeNodeList = new ArrayList<>();
            treeNodeList.add(new TreeNode(start));
            return treeNodeList;
        }

        List<TreeNode> rs = new ArrayList<>();
        for(int i = start; i <= end; i++){
            //i for root
            List<TreeNode> lRootList = getTreeListByRange(start, i - 1);
            List<TreeNode> rRootList = getTreeListByRange(i + 1, end);

            List<TreeNode> combineList = combine(rRootList, lRootList, i);
            rs.addAll(combineList);
        }
        return rs;
    }

    private List<TreeNode> combine(List<TreeNode> rRootList, List<TreeNode> lRootList, int cur) {
        List<TreeNode> treeNodeList = new ArrayList<>();

        if(lRootList == null && rRootList == null){
            treeNodeList.add(new TreeNode(cur));
            return treeNodeList;
        }

        if(lRootList == null){
            for(TreeNode node : rRootList){
                TreeNode curRoot = new TreeNode(cur);
                curRoot.right = node;
                treeNodeList.add(curRoot);
            }
            return treeNodeList;
        }

        if(rRootList == null){
            for(TreeNode node : lRootList){
                TreeNode curRoot = new TreeNode(cur);
                curRoot.left = node;
                treeNodeList.add(curRoot);
            }
            return treeNodeList;
        }

        for(TreeNode left : lRootList){
            for(TreeNode right : rRootList){
                TreeNode curRoot = new TreeNode(cur);
                curRoot.left = left;
                curRoot.right = right;
                treeNodeList.add(curRoot);
            }
        }
        return treeNodeList;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
    }
}
