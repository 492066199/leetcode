package com.sailing.leetcode.solution17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }

        List<String> resultList = new LinkedList<>();
        //init dictionary
        int dir[][] = new int[10][];
        int cur = 'a';
        for(int i = 2; i <= 9; i++){
            if(i != 9 && i != 7) {
                dir[i] = new int[3];
            }else {
                dir[i] = new int[4];
            }

            for (int k = 0 ; k < dir[i].length; k++){
                dir[i][k] = cur;
                cur ++;
            }
        }

        //begin
        int[] map = new int[digits.length()];
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                int index = digits.charAt(i) - '0';
                sb.append((char)(dir[index][map[i]]));
            }
            resultList.add(sb.toString());

            //find next one
            boolean findnext = false;
            for (int k = map.length - 1; k >= 0; k --){
                int index = digits.charAt(k) - '0';
                if(map[k] < dir[index].length - 1){
                    map[k] ++;
                    for(int j = k + 1; j <= map.length - 1; j++){
                        map[j] = 0;
                    }
                    findnext = true;
                    break;
                }
            }

            if(!findnext){
                break;
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
