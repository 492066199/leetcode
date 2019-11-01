package com.sailing.leetcode.solution318;

public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 1){
            return 0;
        }
        int plate[] = new int[26];
        int init = 1;
        for (int i = 0; i < plate.length; i++){
            plate[i] = init;
            init = init << 1;
        }

        int[] wordbit = new int[words.length];
        for(int j = 0; j < words.length; j++){
            for (int i = 0; i < words[j].length(); i++){
                int  p = plate[words[j].charAt(i) - 'a'];
                wordbit[j] = wordbit[j] | p;
            }
        }

        int max = 0;
        for (int i = 0; i < wordbit.length - 1; i++){
            for(int j = i; j < wordbit.length; j++){
                if((wordbit[i] & wordbit[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
