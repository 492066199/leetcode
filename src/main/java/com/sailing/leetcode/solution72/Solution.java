package com.sailing.leetcode.solution72;


/**
 * dp find the state change equation
 */
public class Solution {
    int[][] cahche = null;
    boolean[][] flag = null;
    public int minDistance(String word1, String word2) {
        cahche = new int[word1.length()][word2.length()];
        flag = new boolean[word1.length()][word2.length()];

        return findTheMinHop(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int findTheMinHop(String word1, String word2, int wIndex1, int wIndex2) {
        if(wIndex1 == -1 && wIndex2 == -1){
            return 0;
        }

        if(wIndex1 == -1){
            return wIndex2 + 1;
        }

        if(wIndex2 == -1){
            return wIndex1 + 1;
        }

        if(flag[wIndex1][wIndex2]){
            return cahche[wIndex1][wIndex2];
        }

        char c1 = word1.charAt(wIndex1);
        char c2 = word2.charAt(wIndex2);
        if(c1 == c2){
            int min = findTheMinHop(word1, word2, wIndex1 - 1, wIndex2 - 1);

            flag[wIndex1][wIndex2 ] = true;
            cahche[wIndex1][wIndex2] = min;
            return min;
        }else {
            int delete = findTheMinHop(word1, word2, wIndex1 - 1, wIndex2) + 1;
            int replace = findTheMinHop(word1, word2, wIndex1 - 1, wIndex2 - 1) + 1;
            int insert = findTheMinHop(word1, word2, wIndex1, wIndex2 - 1) + 1;

            int min = Math.min(delete, Math.min(replace, insert));

            flag[wIndex1][wIndex2 ] = true;
            cahche[wIndex1][wIndex2] = min;
            return min;
        }
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
    }
}
