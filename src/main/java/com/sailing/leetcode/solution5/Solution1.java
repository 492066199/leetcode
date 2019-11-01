package com.sailing.leetcode.solution5;

/**
 * beat 45%
 * yangyang 2018-03-11
 */
public class Solution1 {
    int max = 0;
    int center = 0;
    public String longestPalindrome(String s) {
        String o = fill(s);
        int lenght = o.length();
        for(int i = 0; i < lenght; i++){
            int llenght = i;
            int rlenght = lenght - i -1;
            int t = Math.min(llenght, rlenght);
            int count = 0;
            for(int j = 1; j <= t; j++){
                int left = i -j;
                int right = i + j;
                if(o.charAt(left) == o.charAt(right)){
                    count ++;
                }else {
                    break;
                }
            }
            if(count > max){
                max = count;
                center = i;
            }
        }
        return getls(center, max, o);
    }

    private String getls(int center, int max, String o) {
        int start = center -max;
        int end = center + max + 1;
        StringBuilder sb = new StringBuilder(max * 3);
        for(int  i = start; i < end; i ++ ){
            if(o.charAt(i) != '?'){
                sb.append(o.charAt(i));
            }
        }
        return sb.toString();
    }

    private String fill(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 3);
        for(int i = 0; i < s.length(); i ++){
            sb.append('?').append(s.charAt(i));
        }
        sb.append('?');
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abccaccdd";
        System.out.println(new Solution1().longestPalindrome("abb"));
    }
}
