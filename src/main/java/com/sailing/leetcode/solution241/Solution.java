package com.sailing.leetcode.solution241;

import com.google.common.collect.Lists;
import com.sailing.leetcode.other.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ss = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            int c = input.charAt(i);
            switch (c){
                case '-':
                    op.add(1);
                    break;
                case '+':
                    op.add(2);
                    break;
                case '*':
                    op.add(3);
                    break;
                case ' ':
                    continue;
                default:
                    int sum = 0;
                    for(int j = i; j < input.length(); j++){
                        int t = input.charAt(j) - '0';
                        if(t < 0 || t > 9){
                            break;
                        }
                        sum = (input.charAt(j) - '0')  + sum * 10;
                        i = j;
                    }
                    ss.add(sum);
            }
        }

        return clac(ss, op, 0, ss.size() - 1);
    }

    private List<Integer> clac(List<Integer> ss, List<Integer> op, int start, int end) {
        if(start == end){
            List<Integer> t = new ArrayList<>();
            t.add(ss.get(start));
            return t;
        }

        List<Integer> r = new ArrayList<>();
        for (int i = start; i < end; i++){
            List<Integer> leftrs = clac(ss, op, start, i);
            List<Integer> rightrs = clac(ss, op, i + 1, end);
            for (Integer left : leftrs){
                for(Integer right : rightrs){
                    r.add(simpleclac(left, right, op.get(i)));
                }
            }
        }
        return r;
    }

    private Integer simpleclac(Integer left, Integer right, Integer op) {
        if(op == 1){
            return left - right;
        }else if(op == 2){
            return left + right;
        }else {
            return left * right;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2*3-4*5"));
    }
}
