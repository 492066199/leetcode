package com.sailing.leetcode.solution45;


/**
 * yangyang
 * 2018-03-24
 * beat 90%
 */
public class Solution {
    int cache[] = null;
    boolean flag[] = null;
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int cur = 0;
        int pre = 0;
        int cur_step = 0;
        while(true){
            cur_step ++;
            int index = cur + 1;
            for (int i = pre; i <= cur; i++ ){
                int c = nums[i] + i;
                if(c >= index){
                    index = c;
                }

                if(index >= nums.length - 1){
                    return cur_step;
                }
            }

            if(index >= nums.length - 1){
                return cur_step;
            }

            pre = cur;
            cur = index;
        }

//        cache = new int[nums.length];
//        flag = new boolean[nums.length];
//
//        int c = Math.min(nums[0], nums.length - 1);
//        for(int i = 1; i <= c; i++){
//            cache[i] = 1;
//            flag[i] = true;
//        }

//        return travel(nums, nums.length - 1);
    }

    private int travel(int[] nums, int index) {
        if(flag[index]){
            return cache[index];
        }

        if(index == 0){
            return 0;
        }

        if(index == 1){
            return 1;
        }

        int minN = index;
        for(int i = 0; i < index; i++){
            int c = index - i;
            if(nums[i] >= c){
                minN = i;
                break;
            }
        }

        int e = travel(nums, minN);
        int o = e + 1;
        cache[index] = o;
        flag[index] = true;
        return o;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}
