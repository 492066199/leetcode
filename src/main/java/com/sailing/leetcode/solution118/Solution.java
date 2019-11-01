package com.sailing.leetcode.solution118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>(numRows);
        if(numRows <= 0){
            return r;
        }
        List<Integer> hopR = getHopList(numRows, r);
        return r;
    }

    //hop 3
    private List<Integer> getHopList(int hop, List<List<Integer>> r) {
        List<Integer> hopR = new ArrayList<>();
        if(hop == 2){
            hopR.add(1);
            List<Integer> initR = new ArrayList<>(hopR);

            hopR.add(1);

            r.add(initR);
            r.add(hopR);

            return hopR;
        }

        if(hop == 1){
            hopR.add(1);
            r.add(hopR);
            return hopR;
        }


        List<Integer> list = getHopList(hop - 1, r);

        hopR.add(1);
        for(int i = 0; i < list.size() - 1; i++){
            int first = list.get(i);
            int second = list.get(i + 1);
            hopR.add(first + second);
        }
        hopR.add(1);

        r.add(hopR);
        return hopR;
    }
}
