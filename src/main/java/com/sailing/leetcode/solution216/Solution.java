package com.sailing.leetcode.solution216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ss = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> cur = new LinkedList<>();
        trasal(k, n, 9, cur);
        return ss;
    }

    private void trasal(int k, int n, int step, LinkedList<Integer> cur) {
        if(n < 0 || step < 0 || k < 0){
            return;
        }

        if(n == 0 && k == 0){
            ss.add(new ArrayList<>(cur));
            return;
        }

        cur.addLast(step);
        trasal(k - 1, n - step, step - 1, cur);

        cur.removeLast();
        trasal(k, n, step - 1, cur);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3,7));
    }
}
