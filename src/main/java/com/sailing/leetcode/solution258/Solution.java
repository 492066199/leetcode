package com.sailing.leetcode.solution258;

public class Solution {
    public int addDigits(int num) {
        while (num > 9){
            num = tranfer(num);
        }
        
        return num;
    }

    private int tranfer(int num) {
        int sum = 0;
        while (num > 0){
            int r = num % 10;
            sum = sum + r;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}
