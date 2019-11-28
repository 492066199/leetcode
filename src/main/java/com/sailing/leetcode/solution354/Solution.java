package com.sailing.leetcode.solution354;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/***
 *
 * @date 2019-11-28 23:20
 * @author sailingYang
 *
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int[] p : envelopes){
            List<Integer> c = map.get(p[0]);

            //if has the equal! keng!
            if(c == null) {
                c = new ArrayList<>();
                map.put(p[0], c);
            }
            c.add(p[1]);
        }

        List<int[]> dp[] = new List[map.size()];
        int i = 0;
        int max = 1;
        for (List<Integer> li : map.values()){
            //first one
            dp[i] = new ArrayList<>();
            if(i == 0){
                for (Integer tmp : li){
                    dp[i].add(new int[]{tmp, 1});
                }
            }else {
                //for some li
                for (Integer tmp : li) {
                    int curmax = 1;
                    for (int j = 0; j < i; j++) {
                        for (int[] p : dp[j]) {
                            if (p[0] < tmp) {
                                curmax = Math.max(curmax, p[1] + 1);
                            }
                        }
                    }
                    dp[i].add(new int[]{tmp, curmax});
                    max = Math.max(curmax, max);
                }
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
    }
}
