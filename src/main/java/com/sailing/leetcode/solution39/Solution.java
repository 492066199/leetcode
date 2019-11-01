package com.sailing.leetcode.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyang on 2018/3/8.
 * beat 85.9%
 */

public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //must sort
        Arrays.sort(candidates);
        if(target == 0){
            rs.add(new ArrayList<Integer>());
            return rs;
        }

        int count = 0;
        List<Integer> hasChoosed = new ArrayList<>();
        //if choose
        travel(count, candidates, target, hasChoosed);
        //if not choose
        return rs;
    }

    private void travel(int count, int[] candidates, int need, List<Integer> hasChoosed) {
        for(int k = count; k < candidates.length; k++) {
            //choose k
            boolean needbreak = false;
            int cur = candidates[k];
            int diff = need - cur;
            hasChoosed.add(cur);

            if (diff == 0) {
                addresult(hasChoosed);
            } else if (diff > 0) {
                travel(count , candidates, diff, hasChoosed);
            }else {//<
                needbreak = true;
            }

            hasChoosed.remove(hasChoosed.size() - 1);
            count ++;
            if(needbreak){
                break;
            }
        }
    }

    private void addresult(List<Integer> hasChoosed) {
        rs.add(new ArrayList<>(hasChoosed));
    }

    public static void main(String[] args) {
        int[] cc = new int[]{2, 3, 6, 7};
        System.out.println(new Solution().combinationSum(cc, 7));
    }
}
