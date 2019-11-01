package com.sailing.leetcode.solution264;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }

        List<Integer> queue = new ArrayList<>(1800);
        queue.add(1);

        int m2offset = 0;
        int m3offset = 0;
        int m5offset = 0;

        while (queue.size() < n) {
            //find one num

            int curMax = queue.get(queue.size() - 1);
            int m2 = queue.get(m2offset) * 2;
            int m3 = queue.get(m3offset) * 3;
            int m5 = queue.get(m5offset) * 5;

            int m = Math.min(m2, Math.min(m3, m5));
            queue.add(m);
            if(m2 == m) m2offset ++;
            if(m3 == m) m3offset ++;
            if(m5 == m) m5offset ++;
        }

        return queue.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}