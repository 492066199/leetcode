package com.sailing.leetcode.solution65;

/**
 * yanyang 2018-03-11
 * 恶趣味的题目
 * The description do not give a clear explantion of the definition of a valid Number, we just use more and more trick to get the right solution. It’s too bad, it’s waste of my time
 */
public class Solution {
    public boolean isNumber(String s) {
        int start = 0;
        int end = s.length();
        for(; start < end; start++){
            char cur = s.charAt(start);
            if(cur != ' '){
                break;
            }
        }

        for(;start < end; end--){
            char cur = s.charAt(end-1);
            if(cur != ' '){
                break;
            }
        }

        if(start == end){
            return false;
        }

        if(s.charAt(start) == '-' || s.charAt(start) == '+'){
            start ++;
        }

//        if(s.charAt(start) == '0'){
//            start ++;
//        }

        boolean hasDot = false;
        boolean hasE = false;
        int preEIndex = -100000;
        int epreNum = 0;
        int ebackNum = 0;
        int numCount = 0;
        for(int i = start;i < end; i++){
            char cur = s.charAt(i);
            if(cur == '.'){
                if(hasDot || hasE){
                    return false;
                }else {
                    hasDot = true;
                    continue;
                }
            }

            if(cur == 'e'){
                if(hasE){
                    return false;
                }else {
                    preEIndex = i;
                    hasE = true;
                    continue;
                }
            }

            if(preEIndex + 1 == i &&(s.charAt(i) == '-' || s.charAt(i) == '+')){
                continue;
            }

            if((cur <= '9' && cur >= '0') ){
                if(hasE){
                    ebackNum ++;
                }else {
                    epreNum ++;
                }
                numCount++;
                continue;
            }else{
                return false;
            }
        }

        if(numCount == 0){
            return false;
        }

        if(hasE){
            if(ebackNum > 0 && epreNum > 0){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber(" 005047e+6"));
        int c = '9';
        int d = 'a';
        System.out.println(c);
        System.out.println(d);
    }
}
