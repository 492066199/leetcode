package com.sailing.leetcode.solution47;

import java.util.*;

/**
 * Created by yangyang on 2018/3/15.
 * beat 16%
 * 可以用boolen数组替换已经用过的字段
 */
public class Solution {
    int LIMIT = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        LIMIT = nums.length * 2;
        List<Integer> init = new LinkedList<>();
        Arrays.sort(nums);
        for (int n : nums){
            init.add(n);
        }

        List<List<Integer>> rs = getp(init);
        return rs;
    }

    private List<List<Integer>> getp(List<Integer> init) {
        List<List<Integer>> rs = new LinkedList<>();
        if(init.size() == 1){
            List<Integer> r = new ArrayList<>(LIMIT);
            r.add(init.get(0));
            rs.add(r);
        }

        Set<Integer> ss = new HashSet<>();
        Integer pre = null;
        for(int i = 0; i < init.size(); i++){
            Integer cur = init.get(i);
            if(pre == cur){
                continue;
            }

            init.remove(i);
            List<List<Integer>> curRs = getp(init);
            init.add(i, cur);
            ss.add(cur);

            for(List<Integer> curR : curRs){
                curR.add(cur);
                rs.add(curR);
            }

            pre = cur;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,2,1}));
    }
}
