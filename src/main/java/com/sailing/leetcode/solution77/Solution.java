package com.sailing.leetcode.solution77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n < 0 || k < 0 || k > n){
            return new ArrayList<>();
        }

        
        LinkedList<Integer> cur = new LinkedList<>();
        combineAndAddResult(k, cur, 1, n);
        
        return resultList;
    }

    private void combineAndAddResult(int k, LinkedList<Integer> cur, int hop, int n) {
        if(hop > n){
            return;
        }

        int remain = n - hop + 1;
        int need = k - cur.size();
        if(remain < need){
            return;
        }

        //choose
        cur.addLast(hop);
        //满足条件 终止and回溯
        if(cur.size() == k){
            addToResult(cur);
        }else {
        //不满足条件 继续
            combineAndAddResult(k, cur, hop + 1, n);
        }
        //not choose and then next
        cur.removeLast();
        combineAndAddResult(k, cur, hop + 1, n);
    }

    private void addToResult(List<Integer> cur) {
        List<Integer> ss = new ArrayList<>(cur);
        resultList.add(ss);
    }
}
