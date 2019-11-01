package com.sailing.leetcode.solution239;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return new int[0];
        }

        int c = nums.length - k + 1;
        int r[] = new int[c];

        int init = Integer.MIN_VALUE;
        int p = -1;
        for(int i = 0; i < k; i++){
            if(nums[i] > init){
                p = i;
                init = nums[i];
            }
        }

        r[0] = init;
        int last = k - 1;
        int start = 0;
        for(int j = 1; j < r.length; j++){
            start ++;
            last ++;
            if(p >= start){
                if(nums[last] >= nums[p]){
                    p = last;
                    r[j] = nums[last];
                }else {
                    r[j] = nums[p];
                }
            }else {
                if(nums[last] >= nums[p]){
                    p = last;
                    r[j] = nums[last];
                }else {
                    //rebase
                    p = last;
                    r[j] = nums[last];
                    for(int m = start; m < last; m++){
                        if(nums[m] > r[j]){
                            r[j] = nums[m];
                            p = m;
                        }
                    }
                }

            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
