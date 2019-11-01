package com.sailing.leetcode.solution4;

/**
 * yangyang
 * 2018-03-17
 * 太难了
 * beat 27% 有时候80%
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int end1 = nums1.length;
        int end2 = nums2.length;
        if(end1 == 0){
            return getMidNumSingle(nums2);
        }

        if(end2 == 0){
            return getMidNumSingle(nums1);
        }

        int tmp = 0;
        if (end1 == 1){
            tmp = nums1[0];

            nums1 = new int[3];
            nums1[0] = Integer.MIN_VALUE;
            nums1[1] = tmp;
            nums1[2] = Integer.MAX_VALUE;
        }

        if (end2 == 1){
            tmp = nums2[0];

            nums2 = new int[3];
            nums2[0] = Integer.MIN_VALUE;
            nums2[1] = tmp;
            nums2[2] = Integer.MAX_VALUE;

        }

        return getMidNum(nums1, nums2, 0, nums1.length, 0, nums2.length);
    }

    private double getMidNumSingle(int[] nums2) {
        if((nums2.length & 1) == 1){
            return nums2[nums2.length / 2];
        }else {
            return ((double)(nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2])) / 2;
        }
    }

    private double getMidNum(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
        int l1 = end1 - start1;
        if(l1 <= 2){
            return getResult(nums1, start1, end1, nums2, start2, end2);
        }

        int l2 = end2 - start2;
        if(l2 <= 2){
            return getResult(nums2, start2, end2, nums1, start1, end1);
        }
        boolean t = false;

        if(l1 <=4 || l2 <= 4){
            t = true;
        }
        int mid1 = (end1 + start1) / 2;
        int mid2 = (end2 + start2) / 2;

        int c = 1;
        if(nums1[mid1] > nums2[mid2]){
            if(!t) {
                int delete1 = end1 - mid1 - 1;
                int delete2 = mid2 - start2;
                c = Math.min(delete1, delete2);
            }
            return getMidNum(nums1, nums2, start1, end1 - c, start2 + c, end2);
        }else {
            if(!t) {
                int delete1 = end2 - mid2 - 1;
                int delete2 = mid1 - start1;
                c = Math.min(delete1, delete2);
            }
            return getMidNum(nums1, nums2, start1 + c, end1, start2, end2 - c);
        }
    }

    private double getResult(int[] shorts, int start1, int end1, int[] longs, int start2, int end2) {
        int totallength = end1 + end2 - start1 - start2;
        if((totallength & 1) == 1){
            int xp = (start2 + end2) / 2;
            int x0 = longs[xp];
            if(x0 > shorts[end1 - 1]){
                return Math.max(shorts[end1 - 1], longs[xp - 1]);
            }else if(x0 < shorts[start1]){
                return Math.min(shorts[start1], longs[xp + 1]);
            }
            return x0;
        }else {
            int xp = (start2 + end2) / 2;
            int x0 = longs[xp];
            int x1 = longs[xp - 1];

            if(x0 > shorts[end1 - 1]){
                if(shorts[end1 - 1] > longs[xp - 1]){
                    x0 = shorts[end1 - 1];
                    x1 = Math.max(shorts[start1], longs[xp - 1]);
                }else {
                    x0 = longs[xp - 1];
                    if(xp - 2 < 0){
                        x1 = shorts[end1 - 1];
                    }else {
                        x1 = Math.max(shorts[end1 - 1], longs[xp - 2]);
                    }
                }
            }else if(x0 < shorts[start1]){
                if (xp + 1 >= longs.length){
                    x1 = shorts[start1];
                }else {
                    x1 = Math.min(shorts[start1], longs[xp + 1]);
                }
            }else {
                x1 = Math.max(shorts[start1], longs[xp - 1]);
            }
            return ((double) x1 + (double) x0) / 2;
        }
    }

    public static void  main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1,5,6,7}, new int[]{2,3,4,8,9,10}));
    }
}
