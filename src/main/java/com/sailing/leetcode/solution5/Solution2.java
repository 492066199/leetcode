package com.sailing.leetcode.solution5;

/**
 * 2018-03-11
 * yangyang
 * Manacher算法  强势一波 beat 50%
 * --！
 */
public class Solution2 {
    int max = 0;
    int center = 0;

    public String longestPalindrome(String s) {
        String o = fill(s);
        //辅助变量
        int maxCenter = 0;
        int r = 0;
        int p[] = new int[o.length()];
        for(int i = 1; i < o.length(); i++){
            if(r > i){
                p[i] = Math.min(p[maxCenter - (i - maxCenter)], r - i);
            }else {
                p[i] = 0;
            }


            while( (i + p[i] + 1) < o.length() && (i - p[i] - 1) > -1 && o.charAt(i + p[i] + 1) == o.charAt(i - p[i] - 1)){
                p[i] ++;
            }

            if(i + p[i] > r){
                r = i + p[i];
                maxCenter = i;
            }

            if(p[i] > max){
                max = p[i];
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
        System.out.println(new Solution2().longestPalindrome(s));
    }
}
