package com.sailing.leetcode.solution331;

public class Solution {
    boolean cache[][];
    boolean flag[][];
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        String[] token = preorder.split(",");
        if(token.length == 1){
            if(token[0].charAt(0) == '#'){
                return true;
            }else {
                return false;
            }
        }
        if(token.length % 2 == 0){
            return false;
        }

        cache = new boolean[token.length + 1][token.length + 1];
        flag = new boolean[token.length + 1][token.length + 1];

        return isValid(token, 0 , token.length - 1);
    }

    private boolean isValid(String[] token, int start, int end) {
        if(flag[start][end]){
            return cache[start][end];
        }

        if((end - start) % 2 != 0){
            return false;
        }

        if(start == end){
            if(token[start].charAt(0) == '#')
                return true;
            else
                return false;
        }

        if(token[end].charAt(0) != '#'){
            flag[start][end] = false;
            cache[start][end] = true;
            return false;
        }

        if(end - start == 2){
            if(token[start].charAt(0) != '#' && token[start + 1].charAt(0) == '#' && token[end].charAt(0) == '#'){
                flag[start][end] = true;
                cache[start][end] = true;

                return true;
            }else {

                flag[start][end] = true;
                cache[start][end] = false;

                return false;
            }
        }


        if(token[start].length() == 1 && token[start].charAt(0) == '#'){
            return false;
        }

        //k is the right branch root
        //start + 1 --> k -1
        //k --> end
        for (int k = start + 2; k <= end; k = k + 2){
            String cur = token[k];
            if(cur.length() == 1 && cur.charAt(0) == '#'){
                if(k != end){
                    continue;
                }
            }

//            System.out.println(start);
            if (token[k - 1].charAt(0) != '#'){
                continue;
            }
            if(isValid(token, start + 1, k - 1) &&
                    isValid(token, k, end)){
                flag[start][end] = true;
                cache[start][end] = true;
                return true;
            }
        }

        flag[start][end] = true;
        cache[start][end] = false;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("1"));
        System.out.println(new Solution().isValidSerialization("9,9,9,9,9,9,9,9,#,9,#,#,9,#,9,#,#,#,9,9,#,9,#,#,9,#,9,#,#,9,9,9,#,9,#,#,9,#,#,9,#,#,9,9,9,9,9,#,#,#,9,9,#,9,9,9,9,#,#,#,#,9,#,9,9,#,#,#,9,#,#,9,9,9,#,#,9,9,#,#,9,9,#,#,#,9,#,9,9,9,9,#,#,#,#,9,#,#,9,9,9,#,9,#,#,9,9,9,#,#,9,#,#,9,9,#,9,#,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,9,9,9,#,9,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,#,9,9,9,#,#,9,#,#,9,9,9,#,#,9,9,#,#,#,9,#,9,#,9,#,#"));
    }
}
