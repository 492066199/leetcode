package com.sailing.leetcode.solution22;

import java.util.LinkedList;
import java.util.List;

/**
 * yangyang
 * 2018-03-23
 * beat 87%
 */
public class Solution {
    List<String> rs = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        int[] flag = new int[2 * n];
        for(int i = 0; i < flag.length - 1; i++){
            flag[i] = 1;
        }
        flag[flag.length - 1] = -1;
        int cur = 1;
        travel(flag, 1, n - 1, cur);
        return rs;
    }

    private void travel(int[] flag, int index, int remain, int cur) {
        if (remain == 0){
            addToResult(flag);
            return;
        }

        int remainDot = flag.length - index - 1;
        if(remain == remainDot){
            for(int i = index; i < flag.length - 1; i++){
                flag[i] = -1;
            }
            addToResult(flag);
            //remove state
            for(int i = index; i < flag.length - 1; i++){
                flag[i] = 1;
            }
            return;
        }

        //choose
        flag[index] = -1;
        cur = cur - 1;
        if(cur >= 0){
            travel(flag, index + 1, remain - 1, cur);
        }
        //remove state
        flag[index] = 1;
        cur = cur + 2;
        travel(flag, index + 1, remain, cur);
    }

    private void addToResult(int[] flag) {
        StringBuilder sb = new StringBuilder(flag.length + 2);
        for(int i = 0; i < flag.length; i++){
            if(flag[i] == 1) {
                sb.append('(');
            }else {
                sb.append(')');
            }
        }
        rs.add(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
