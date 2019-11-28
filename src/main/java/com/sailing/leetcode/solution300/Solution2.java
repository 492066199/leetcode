package com.sailing.leetcode.solution300;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/***
 *
 *
 * use treeMap for better performance
 *
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        //use key as the last num, the longest count we store in value!
        TreeMap<Integer, Integer> dptree = new TreeMap<>();
        //init: use num[0] as the last num, we store the 1 as the count;
        dptree.put(nums[0], 1);

        int max = 1;
        //so we seek for other dptree[i]
        for(int i = 1; i < nums.length; i++){
            //dp[i]
            int cur = nums[i];
            NavigableMap<Integer, Integer> submap = dptree.headMap(cur, false);
            int curmax = 1;
            for (Integer v : submap.values()){
                curmax = Math.max(v + 1, curmax);
                max = Math.max(curmax, max);
            }

            dptree.put(nums[i], curmax);
        }

        return max;
    }

    public static void main(String[] args) {
        new Solution2().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
