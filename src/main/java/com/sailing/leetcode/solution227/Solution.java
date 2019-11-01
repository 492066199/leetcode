package com.sailing.leetcode.solution227;

import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Boolean> f = new LinkedList<>();
        int preNum = 0;
        char pref = '+';
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '+':
                    nums.add(preNum);
                    f.add(true);
                    pref = '+';
                    break;
                case '-':
                    nums.add(preNum);
                    f.add(false);
                    pref = '-';
                    break;
                case '/':
                    pref = '/';
                    break;
                case '*':
                    pref = '*';
                    break;
                case ' ':
                    continue;
                default:
                    int sum = 0;
                    int j = i;
                    while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        sum = sum * 10 + s.charAt(j) - '0';
                        i = j;
                        j++;
                    }
                    if(pref == '/') {
                        preNum = preNum / sum;
                    }else if(pref == '*'){
                        preNum = preNum * sum;
                    }else {
                        preNum = sum;
                    }
            }
        }
        nums.add(preNum);

        int total = nums.removeFirst();
        while (nums.size() > 0){
            int op = nums.removeFirst();
            boolean c = f.removeFirst();
            if(c){
                total = total + op;
            }else {
                total = total - op;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
    }
}
