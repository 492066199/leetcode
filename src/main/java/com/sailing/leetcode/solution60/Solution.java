package com.sailing.leetcode.solution60;

import java.util.ArrayList;
import java.util.List;

/**
 * beat 87%
 */
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> a = new ArrayList<>(2 *n);
        for(int i = 1; i <= n; i++){
            a.add(i);
        }
        return getK(a, k - 1, n - 1);
    }

    private String getK(List<Integer> a, int k, int cur) {
        if(a.size() == 1){
            return a.get(0) + "";
        }
        int ans = getI(cur);
        int c = k / ans;
        int now = a.remove(c);

        int remain = k - ans * c;
        String d = getK(a, remain, cur - 1);
        return now + "" + d;
    }

    public int getI(int k) {
        int d = 1;
        int c = 1;
        for(int i = 0;i < k ; i++ ) {
            d = d * c;
            c++;
        }
        return d;
    }


    public static void main(String[] args) {
        int c = new Solution().getI(0);
        System.out.println(new Solution().getPermutation(4, 1));
    }
}
