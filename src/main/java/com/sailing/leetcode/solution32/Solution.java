package com.sailing.leetcode.solution32;

/***
 * beat 87%
 * yangyang
 * 2018-03-18!
 */
public class Solution {


    public int longestValidParentheses(String s) {
        int maxPoint = -1;
        if(s.length() == 0){
            return 0;
        }
        int[] ll = new int[s.length()];

        for(int  i = 0; i < s.length(); i ++){
            char cur = s.charAt(i);
            if(cur == '('){
                ll[i] = 0;
                continue;
            }else {
                if(i - 1 == -1){
                    ll[i] = 0;
                }else {
                    char precur = s.charAt(i - 1);
                    if (precur == ')') {
                        int preMaxLength = ll[i - 1];
                        int checkIndex = i - 1 - preMaxLength;
                        if (checkIndex >= 0 && s.charAt(checkIndex) == '(') {
                            int mostCheck = checkIndex - 1;
                            if(mostCheck - 1 >= 0){
                                ll[i] = preMaxLength + 2 + ll[mostCheck];
                            }else {
                                ll[i] = preMaxLength + 2;
                            }
                        } else {
                            ll[i] = 0;
                        }
                    } else {
                        int preMaxIndex = i - 2;
                        if (preMaxIndex >= 0) {
                            ll[i] = ll[preMaxIndex] + 2;
                        } else {
                            ll[i] = 2;
                        }
                    }
                }
                if(ll[i] > maxPoint && ll[i] != 0){
                    maxPoint = ll[i];
                }
            }
        }

        if(maxPoint == -1){
            return 0;
        }
        return maxPoint;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()"));
    }
}
