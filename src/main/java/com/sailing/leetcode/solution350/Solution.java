package com.sailing.leetcode.solution350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> r = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                i ++;
                j ++;

                r.add(nums1[i - 1]);
            }else if(nums1[i] < nums2[j]){
                i ++;
            }else {
                j ++;
            }
        }

        int fr[] = new int[r.size()];

        for(int k = 0; k < r.size(); k++){
            fr[k] = r.get(k);
        }

        return fr;
    }
}
