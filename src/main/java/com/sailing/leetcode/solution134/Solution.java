package com.sailing.leetcode.solution134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0){
            return -1;
        }

        if(gas.length == 1){
            if(gas[0] >= cost[0]){
                return 0;
            }else {
                return -1;
            }
        }


        int[] remain = new int[gas.length];
        int [] front_need = new int[gas.length];

        //init
        remain[gas.length - 1] = gas[gas.length - 1] - cost[cost.length - 1];
        if(remain[gas.length - 1] < 0){
            front_need[gas.length - 1] = remain[gas.length - 1];
            remain[gas.length - 1] = 0;
        }
        for (int i = gas.length - 2; i >= 0; i --){
            int cur = gas[i] - cost[i];
            if(cur >= 0) {
                if(front_need[i + 1] + cur >= 0){
                    front_need[i] = 0;
                    remain[i] = remain[i + 1] + front_need[i + 1] + cur;
                }else {
                    remain[i] = remain[i + 1];
                    front_need[i] = front_need[i + 1] + cur;
                }
            }else {
                remain[i] = remain[i + 1];
                front_need[i] = front_need[i + 1] + cur;
            }
        }

        int[] need = new int[gas.length];
        int[] other_remain = new int[gas.length];
        need[0] = 0;
        other_remain[0] = 0;

        for(int j = 1; j < gas.length; j ++){
            int cur = gas[j - 1] - cost[j - 1];
            if(cur >= 0){
                need[j] = need[j - 1];
                other_remain[j] = other_remain[j - 1] + cur;
            }else {
                if(other_remain[j - 1]  + cur >= 0){
                    need[j] = need[j - 1];
                    other_remain[j] = other_remain[j - 1]  + cur;
                }else {
                    other_remain[j] = 0;
                    need[j] = need[j - 1] + other_remain[j - 1]  + cur;
                }
            }
        }

        for (int i = 0; i < front_need.length; i++){
            if(front_need[i] >= 0){
                if(need[i] + remain[i] >= 0){
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * [5,1,2,3,4]
     [4,4,1,5,1]
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{5, 1,2,3,4},
                new int[]{4,4,1,5,1}));
    }
}
