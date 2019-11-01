package com.sailing.leetcode.solution67;

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null){
            return null;
        }

        int length = Math.max(a.length(), b.length());
        char r[] = new char[length];
        int count = 0;
        int incur = 0;

        while (count <= length - 1){
            int aIndex = a.length() - 1 - count;
            char aCur = '0';
            if(aIndex >= 0) {
                aCur = a.charAt(aIndex);
            }

            int bIndex =  b.length() - 1 - count;
            char bCur = '0';
            if(bIndex >= 0) {
                bCur = b.charAt(bIndex);
            }

            int curSum = (aCur - '0') + (bCur - '0') + incur;
            int rindex = length - 1 - count;
            if(curSum == 3){
                incur = 1;
                r[rindex] = '1';
            }else if(curSum == 2){
                incur = 1;
                r[rindex] = '0';
            }else if(curSum == 1){
                incur = 0;
                r[rindex] = '1';
            }else {
                incur = 0;
                r[rindex] = '0';
            }

            count ++;
        }
        StringBuilder sb = new StringBuilder();
        if(incur == 1){
            sb.append(1);
        }

        for(int i = 0; i < length; i ++){
            sb.append(r[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "11"));
    }
}
