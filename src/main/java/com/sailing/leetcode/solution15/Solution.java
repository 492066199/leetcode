package com.sailing.leetcode.solution15;

import java.util.*;

/**
 * Created by yangyang on 2018/3/16.
 * copy 自己实现的只beat了11%
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> rs = new LinkedList<>();
        Arrays.sort(num);
        Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            mm.put(num[i], i);
        }

        for (int i = 0; i < num.length - 2; i++) {
            if(i > 0 && num[i] == num[i-1]){
                continue;
            }
            for(int j = i + 1; j < num.length - 1; j++){
                if(j > i + 1 && num[j] == num[j-1]){
                    continue;
                }
                int target = - num[i] - num[j];
                Integer v = mm.get(target);
                if(v != null && v > j){
                    List<Integer> ss = new ArrayList<>();
                    ss.add(num[i]);
                    ss.add(num[j]);
                    ss.add(target);

                    rs.add(ss);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
