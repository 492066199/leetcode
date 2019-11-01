package com.sailing.leetcode.solution46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangyang on 2018/3/15.
 * refine@
 * beat 65%
 */
public class Solution {
    int LIMIT = 0;
    List<List<Integer>> rs = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] f = new boolean[nums.length];
        LIMIT = 2 * nums.length;
        addToPermuteList(nums, f, nums.length, new ArrayList<Integer>(LIMIT));

        return rs;
    }

    private void addToPermuteList(int[] nums, boolean[] f, int remain, List<Integer> cur) {
        if(remain == 1){
            for(int j = 0; j < nums.length; j++){
                if(!f[j]){
                    cur.add(nums[j]);
                    break;
                }
            }
            rs.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);

        }else {
            for (int i = 0; i < nums.length; i++) {
                if (f[i]) {
                    continue;
                }

                f[i] = true;
                cur.add(nums[i]);

                addToPermuteList(nums, f, remain - 1, cur);

                f[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}
