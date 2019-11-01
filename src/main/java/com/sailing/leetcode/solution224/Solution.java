package com.sailing.leetcode.solution224;


public class Solution {
    public int calculate(String s) {
        int target = 0;
        char mup = '+';

        for (int i = 0; i < s.length(); i++){
            boolean flag = false;
            char c = s.charAt(i);
            int cur = 0;

            switch (c){
                case '+':
                case '-':
                    mup = c;
                    break;
                case ' ':
                    continue;
                case '(':
                    int pp = 1;
                    int base = i + 1;
                    int k = i + 1;
                    while (pp != 0){
                        char d = s.charAt(k);
                        if(d == ')'){
                            pp --;
                        }else if(d == '('){
                            pp++;
                        }
                        k++;
                    }
                    cur = calculate(s.substring(base, k - 1));
                    i = k - 1;
                    flag = true;
                    break;
                default:
                    int sum = 0;
                    int j = i;
                    while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        sum = sum * 10 + s.charAt(j) - '0';
                        i = j;
                        j++;
                    }
                    cur = sum;
                    flag = true;
            }

            if(flag){
                if(mup == '+'){
                    target = target + cur;
                }else {
                    target = target - cur;
                }
            }
        }

        return target;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
