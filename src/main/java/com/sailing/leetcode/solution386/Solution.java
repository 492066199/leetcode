package com.sailing.leetcode.solution386;


import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 * @author sailingYang
 * @date   2019-12-22
 *
 */
public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n + 2);
        dfs(n, 0, result);
        return result;
    }

    private void dfs(int n, int start, List<Integer> result) {
        int i = 1;
        if(start > 0){
            i = 0;
        }
        for (; i <= 9; i++){
            int cur = start * 10 + i;
            if(cur > n){
                return;
            }else {
                result.add(cur);
                dfs(n, cur, result);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().lexicalOrder(13));

        System.out.println("hello world!");
    }
}
