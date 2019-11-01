package com.sailing.leetcode.solution179;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null){
            return null;
        }

        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }

        List<String> numStrings = new ArrayList<>(nums.length + 1);
        int zerocount = 0;
        int count = 0;
        for(int num : nums){
            if(num != 0) {
                String cur = String.valueOf(num);
                numStrings.add(cur);
                count = count + cur.length();
            }else {
                zerocount ++;
            }
        }

        if(numStrings.size() == 0){
            return "0";
        }

        numStrings.sort(
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String o1o2 = o1 + o2;
                    String o2o1 = o2 + o1;
                    return o2o1.compareTo(o1o2);
                }
            }
        );

        StringBuilder sb = new StringBuilder(count);
        for(String s : numStrings){
            sb.append(s);
        }

        while (zerocount > 0){
            sb.append('0');
            zerocount --;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3, 2}));
    }
}
