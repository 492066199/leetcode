package com.sailing.leetcode.solution88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null){
            return;
        }

        int[] nums1Backup = new int[m];
        for(int i = 0; i < m; i++){
            nums1Backup[i] = nums1[i];
        }

        int[] result = nums1;

        int nums1Index = 0;
        int nums2Index = 0;

        int resultIndex = 0;

        while (nums1Index < m && nums2Index < n){
            if(nums1Backup[nums1Index] <= nums2[nums2Index]){
                result[resultIndex] = nums1Backup[nums1Index];
                nums1Index ++;
                resultIndex ++;
            }else {
                result[resultIndex] = nums2[nums2Index];
                nums2Index ++;
                resultIndex ++;
            }
        }

        //num1 remain
        if(nums1Index < m){
            for(; nums1Index < m;nums1Index++){
                result[resultIndex] = nums1Backup[nums1Index];
                resultIndex++;
            }
        }

        //num2 remain
        if(nums2Index < n){
            for(; nums2Index < n;nums2Index++){
                result[resultIndex] = nums2[nums2Index];
                resultIndex++;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
