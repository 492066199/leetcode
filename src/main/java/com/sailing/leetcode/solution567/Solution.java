package com.sailing.leetcode.solution567;

import java.util.Arrays;

/**
 * Created by yangyang on 2018/3/15.
 * beat 12%
 * slider windows is perfect！
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] pm = new int[27];
        for(int i = 0; i < s1.length(); i++){
            pm[s1.charAt(i) - 97] = pm[s1.charAt(i) - 97] + 1;
        }

        int span = s1.length();
        char[] c = s2.toCharArray();
        int count = 0;
        for(int i = 0; i + span <= c.length; i++){
            int[] pmm = Arrays.copyOf(pm, 27);
            for(int j = i; j < i + span; j++){
                char d = s2.charAt(j);
                if(--pmm[d - 97] < 0){
                    count++;
                    break;
                }
            }
//            checkZero(pmm);
        }
        if((s2.length() - s1.length() + 1) > count){
            return true;
        }
        return false;
    }

    private void checkZero(int[] pmm) {

    }


    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("hello",
                "ooolleoooleh"));
    }
}
