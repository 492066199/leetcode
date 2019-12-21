package com.sailing.leetcode.solution385;


import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author sailingyang
 * @date   2019-12-21
 *
 * Given s = "324",
 * Given s = "[123,[456,[789]]]",
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) == '['){
            String newStr = s.substring(1, s.length() - 1);
            List<String> ss = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int fc = 0;
            for(int i = 0; i < newStr.length(); i++){
               char cur = newStr.charAt(i);
               if(cur == '['){
                   fc ++;
                   sb.append(cur);
               }else if(cur == ']'){
                   fc --;
                   sb.append(cur);
               }else if(cur == ',' && fc == 0){
                   ss.add(sb.toString());
                   sb = new StringBuilder();
               }else {
                   sb.append(cur);
               }
            }

            if(sb.length() != 0){
                ss.add(sb.toString());
            }

            NestedInteger nestedInteger = new NestedInteger();
            for (String str : ss){
                nestedInteger.add(deserialize(str));
            }

            return nestedInteger;
        }else {
            return new NestedInteger(Integer.parseInt(s));
        }
    }
}
