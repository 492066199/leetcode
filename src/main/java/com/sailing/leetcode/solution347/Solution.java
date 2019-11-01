package com.sailing.leetcode.solution347;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            Integer f = map.get(num);
            if(f == null){
                f = 1;
            }else{
                f++;
            }
            map.put(num, f);
        }

        Map<Integer, List<Integer>> rs = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer f = entry.getValue();

            List<Integer> dkey = rs.get(f);
            if(dkey == null){
                sorted.add(f);
                dkey = new ArrayList<>();
                rs.put(f, dkey);
            }

            dkey.add(key);
        }

        Collections.sort(sorted);
        List<Integer> fr = new ArrayList<>();
        for (int i = sorted.size() - 1; i >= 0; i--){
            List<Integer> cc = rs.get(sorted.get(i));
            for (Integer c : cc){
                fr.add(c);
                if(fr.size() == k){
                    return fr;
                }
            }
        }

        return fr;
    }
}
