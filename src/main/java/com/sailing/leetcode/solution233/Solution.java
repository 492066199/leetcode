package com.sailing.leetcode.solution233;

import java.util.LinkedList;

public class Solution {
    public int countDigitOne(int n) {
        if(n <= 0){
            return 0;
        }
        if(n < 10){
            return 1;
        }
        LinkedList<Integer> ls = new LinkedList<>();
        int count = 0;
        int remain = n;
        while (remain > 0){
            int c = remain % 10;
            remain = remain / 10;
            count ++;
            ls.addLast(c);
        }

        int[] quick = new int[count];
        getQuick(quick, count);
        return calc(quick, ls, count, n);
    }

    // 0000 -> 10000
    private void getQuick(int[] quick, int count) {
        quick[0] = 0;
        quick[1] = 1;
        for(int i = 2; i < count; i++){
            quick[i] = quick[i - 1] * 10 +  fpowerten(i - 1);
        }
    }

    private int calc(int[] quick, LinkedList<Integer> ls, int count, int n) {
        if(count == 1){
            if(ls.removeLast() >= 1){
                return 1;
            }else {
                return 0;
            }
        }
        int x = ls.removeLast();
        int remain = n - x * fpowerten(count - 1);

        //first 0000 -> 9999
        int sum = quick[count - 1];

        //find x = 2 -> 9
        if(x > 1){
            //first 1 appear times
            int fa = fpowerten(count - 1);

            //remain 1 appear times //00000 -> x00000
            sum = x * sum + calc(quick, ls, count - 1, remain) + fa;
        }else if(x == 1){
            //first 1 appaear times
            int remainNum = remain + 1;

            // remain 1 appear times //00000 -> 100000
            sum = x * sum + remainNum + calc(quick, ls, count - 1, remain);
        }else {
            sum = calc(quick, ls, count - 1, remain);
        }

        return sum;
    }

    private int fpowerten(int i) {
        int sum = 1;
        while (i > 0){
            sum = sum * 10;
            i--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(99));
    }
}
