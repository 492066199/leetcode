package com.sailing.leetcode.solution40;

import java.util.*;

/**
 * yangyang
 * 2018-03-24
 * beat 96%
 * 用小技能规避去重!
 */
public class Solution {
    List<List<Integer>> ss = new LinkedList<>();
//    Set<String> used = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        int cur = 0;
        travel(candidates, target ,0, cur, flag);
        return ss;
    }

    private void travel(int[] candidates, int target, int i, int cur, boolean[] flag) {
        if(cur == target){
            addToResult(flag, candidates);
            return;
        }

        if(i >= candidates.length){
            return;
        }

        if(cur > target){
            return;
        }
        int pre = i - 1;
        if(pre >= 0 && candidates[pre] == candidates[i] && !flag[pre]){
            //only try remove
            flag[i] = false;
            travel(candidates, target, i + 1, cur, flag);
            return;
        }

        //choose
        flag[i] = true;
        cur = cur + candidates[i];
        travel(candidates, target, i + 1, cur, flag);



        //remove
        flag[i] = false;
        if(cur > target){
            return;
        }
        cur = cur - candidates[i];
        travel(candidates, target, i + 1, cur, flag);
    }

    private void addToResult(boolean[] flag, int[] candidates) {
        List<Integer> r = new ArrayList<>(candidates.length + 2);
        for(int i = 0; i < candidates.length; i++){
            if(flag[i]){
                r.add(candidates[i]);
            }
        }
        ss.add(r);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
