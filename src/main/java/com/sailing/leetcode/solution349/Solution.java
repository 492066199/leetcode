package com.sailing.leetcode.solution349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }

        Set<Integer> ss = new HashSet<>();
        for(int num : nums1){
            ss.add(num);
        }

        Set<Integer> r = new HashSet<>();
        for(int num : nums2){
            if(ss.contains(num) && !r.contains(num)){
                r.add(num);
            }
        }

        int[] fr = new int[r.size()];
        int c = 0;
        for(Integer rr : r){
            fr[c] = rr;
            c++;
        }
        Arrays.sort(fr);
        return fr;
    }
}
