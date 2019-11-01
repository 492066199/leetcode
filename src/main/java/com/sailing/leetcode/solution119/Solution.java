package com.sailing.leetcode.solution119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> rs = new ArrayList<>();

        if(rowIndex <= 0){
            return rs;
        }

        if(rowIndex == 1){
            rs.add(1);
            return rs;
        }

        if(rowIndex == 2){
            rs.add(1);
            rs.add(1);
            return rs;
        }

        int[] r = new int[rowIndex];
        r[0] = 1;
        r[1] = 1;

        for(int i = 3; i <= rowIndex; i++){

            int bak = r[0];
            for(int j = 1; j < i - 1; j++){
                int c = r[j];
                r[j] = r[j] + bak;
                bak = c;
            }
            r[0] = 1;
            r[i - 1] = 1;
        }

        for(int c : r){
            rs.add(c);
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(5));
    }
}
