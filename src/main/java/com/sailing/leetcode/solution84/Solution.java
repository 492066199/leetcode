package com.sailing.leetcode.solution84;

import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
        Map<Integer, Set<Integer>> ss = new HashMap<>();
        List<Integer> hs =  new ArrayList<>();

        //init
        for(int i = 0; i < height.length; i++){
            int h = height[i];
            Set<Integer> si = ss.get(h);
            if(si == null){
                //first time
                hs.add(h);
                si = new HashSet<>();
                ss.put(h, si);
            }
            si.add(i);
        }

        int max = 0;

        Collections.sort(hs);
        boolean[] r = new boolean[height.length];
        for(int i = hs.size() - 1; i >=  0; i --){
            int curh = hs.get(i);
            Set<Integer> cc = ss.get(curh);

            //broad => left and right
            for (Integer index : cc){
                if(r[index]){
                    continue;
                }
                int left = 0;
                int right = 0;

                int cur = index + 1;
                while (cur < height.length && height[cur] >= curh){
                    r[cur] = true;
                    cur ++;
                    right ++;
                }

                cur = index - 1;
                while (cur >= 0 && height[cur] >= curh){
                    r[cur] = true;
                    cur --;
                    left ++;
                }
                int sum = (left + right + 1) * curh;
                max = Math.max(sum , max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
