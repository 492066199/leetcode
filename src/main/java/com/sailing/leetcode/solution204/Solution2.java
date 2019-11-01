package com.sailing.leetcode.solution204;

public class Solution2 {
    public int countPrimes(int n) {
        if(n < 3){
            return 0;
        }

        boolean[] flag = new boolean[n];
        int k = (int) Math.sqrt(n);
        for(int i = 2; i <= k; i++){
            if(flag[i]){
                continue;
            }

            for (int j = i; j <= n / 2; j++){
                int v = i * j;
                if(v < n){
                    flag[v] = true;
                }else{
                    break;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if(!flag[i]){
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countPrimes(10000));
    }
}
