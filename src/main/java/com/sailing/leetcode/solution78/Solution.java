package com.sailing.leetcode.solution78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> rs = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        LinkedList<Integer> cur = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++){
            getNNumFromSet(nums, i, 0, cur);
        }

        return rs;
    }

    private void getNNumFromSet(int[] nums, int k, int last, LinkedList<Integer> cur) {
        if(k == 0){
            rs.add(new ArrayList<>(cur));
            return;
        }

        int remain = nums.length - last;
        if(k > remain){
            return;
        }

        for(int i = last; i < nums.length; i++){
            //choose
            cur.addLast(nums[i]);
            getNNumFromSet(nums, k - 1, i + 1, cur);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3, 4}));
    }
}
