package com.sailing.leetcode.solution973;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/***
 *
 * @author sailingYang
 * @date  2019-11-28 20:37
 *
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, List<int[]>> t = new TreeMap<>();
        int count = 0;
        for (int[] p : points){
            int mf = p[0] * p[0] + p[1] * p[1];
            List<int[]> tl = t.get(mf);
            if(tl == null){
                tl = new ArrayList<>();
            }
            tl.add(p);
            t.put(mf, tl);
            count ++;

            if(count > K){
                 tl = t.lastEntry().getValue();
                 if(tl.size() == 1){
                     t.pollLastEntry();
                 }else {
                     tl.remove(tl.size() - 1);
                 }
            }
        }

        int[][] r = new int[K][];
        int fcount = 0;
        for(Map.Entry<Integer, List<int[]>> p : t.entrySet()){
            for(int[] pp : p.getValue()) {
                r[fcount] = pp;
                fcount++;
            }
        }

        return r;
    }
}
