package com.sailing.leetcode.solution331;

public class Solution1 {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int r = helper(tokens, 0);
        if(r == -1 || r != tokens.length - 1){
            return false;
        }

        return true;
    }

    private int helper(String[] tokens, int start) {
        if(start > tokens.length - 1){
            return -1;
        }

        if (tokens[start].charAt(0) == '#'){
            return start;
        }

        int left = helper(tokens, start + 1);
        if(left == -1){
            return -1;
        }

        int right = helper(tokens, left + 1);
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution1().isValidSerialization("1"));
        System.out.println(new Solution1().isValidSerialization("9,9,9,9,9,9,9,9,#,9,#,#,9,#,9,#,#,#,9,9,#,9,#,#,9,#,9,#,#,9,9,9,#,9,#,#,9,#,#,9,#,#,9,9,9,9,9,#,#,#,9,9,#,9,9,9,9,#,#,#,#,9,#,9,9,#,#,#,9,#,#,9,9,9,#,#,9,9,#,#,9,9,#,#,#,9,#,9,9,9,9,#,#,#,#,9,#,#,9,9,9,#,9,#,#,9,9,9,#,#,9,#,#,9,9,#,9,#,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,9,9,9,#,9,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,#,9,9,9,#,#,9,#,#,9,9,9,#,#,9,9,#,#,#,9,#,9,#,9,#,#"));
    }
}
