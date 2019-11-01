package com.sailing.leetcode.solution282;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0){
            return new ArrayList<>();
        }
        int[] nums = new int[num.length()];
        for(int i = 0; i < num.length(); i++){
            nums[i] = num.charAt(i) - '0';
        }

        List<String> rs = collect(nums, nums.length - 1, target);
        return rs;
    }

    private List<String> collect(int[] nums, int end, int target) {
        //
        List<String> rs = new ArrayList<>();
        if(end == 0){
            if(nums[end] == target) {
                rs.add(String.valueOf(target));
            }
            return rs;
        }

        if(end == 1){
            int a = nums[0];
            int b = nums[1];
            if(a - b == target){
                rs.add(a + "-" + b);
            }

            if(a + b == target){
                rs.add(a + "+" + b);
            }

            if(a * b == target){
                rs.add(a + "*" + b);
            }

            if(a * 10 + b == target && a != 0){
                rs.add(a + "" + b);
            }
            return rs;
        }

        List<Info> right = new ArrayList<>();
        for(int i = end; i >= 0; i--){
            //* and connect
            right = construct(i, end, nums, right);
            for(Info info : right){
                if(!info.valid){
                    continue;
                }
                if(i == 0 && info.c == target){
                    rs.add(info.str);
                    continue;
                }
                //add
                List<String> add = collect(nums, i - 1, target - info.c);
                if(info.c != 0) {
                    //minus
                    List<String> minus = collect(nums, i - 1, target + info.c);
                    addto(rs, minus, "-", info.str);
                }else {
                    addto(rs, add, "-", info.str);
                }
                addto(rs, add, "+", info.str);
            }
        }

        return rs;
    }

    private void addto(List<String> rs, List<String> collect, String op, String s) {
        for(String c : collect){
            rs.add(c + op + s);
        }
    }

    private List<Info> construct(int start, int end, int[] nums, List<Info> cache) {
        if(start == end){
            Info info = new Info();
            info.lastNum = nums[end];
            info.str = nums[end] + "";
            info.c = nums[end];

            List<Info> s = new ArrayList<>();
            s.add(info);

            return s;
        }

        int c = nums[start];
        List<Info> s = new ArrayList<>(cache.size() * 2 + 1);
        for ( Info info : cache){
            //use * and use connect
            if(info.valid) {
                s.add(info.newProduct(c));
            }
            Info i = info.toConnect(c);
            if(i != null) {
                s.add(i);
            }
        }

        return s;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("1005", 5));
        System.out.println(new Solution().addOperators("000", 0));
        System.out.println(new Solution().addOperators("10000009", 9));
        System.out.println(new Solution().addOperators("123456789", 45));
        System.out.println(new Solution().addOperators("1000", 0));
    }

    public static class Info {
        public int c;
        public String str;
        public int lastNum;
        public boolean valid = true;

        public Info newProduct(int c) {
            Info info = new Info();
            info.c = c * this.c;
            info.str = c + "*" + this.str;
            info.lastNum = c;
            return info;
        }

        public Info toConnect(int c) {
            this.str = c + this.str;
            if(c == 0) {
                this.valid = false;
                return this;
            }
            this.valid = true;
            String[] cs = str.split("\\*");
            int p = 1;
            try {
                this.lastNum = Integer.parseInt(cs[0]);
            } catch (Exception e) {
                return null;
            }
            for (String k : cs) {
                p = p * Integer.parseInt(k);
            }
            this.c = p;
            return this;
        }
    }
}
