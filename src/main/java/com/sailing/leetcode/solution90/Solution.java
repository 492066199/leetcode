package com.sailing.leetcode.solution90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return rs;
        }

        Arrays.sort(nums);
        rs.add(new ArrayList<>());
        LinkedList<Integer> cur =new LinkedList<>();
//        for(int i = 1; i <= nums.length; i++) {
            getByHop(nums, 0, 0, cur, nums.length);
//        }

        return rs;
    }

    //every hop must choose one
    private void getByHop(int[] nums, int last, int hop, LinkedList<Integer> cur, int total) {
//        int need = total - hop;
//        int remain = nums.length - last;
//        if(need > remain){
//            return;
//        }

        if(total < cur.size()){
            return;
        }

        if(total >= cur.size() && cur.size() >= 1){
            rs.add(new ArrayList<>(cur));
        }


        for (int i = last; i < nums.length; i++) {
            if(i - 1 >= last){
                if(nums[i - 1] == nums[i]){
                    continue;
                }
            }

//            remain = nums.length - i;
//            if(need > remain){
//                return;
//            }

            //choose i
            cur.addLast(nums[i]);
            getByHop(nums, i + 1, hop + 1, cur, total);

            //not choose i
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
