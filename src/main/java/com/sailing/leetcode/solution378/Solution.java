package com.sailing.leetcode.solution378;


/***
 *
 * @author sailingYang
 * @date 2019-12-11 22:22
 *
 *
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix[0].length;
        int[] offset = new int[length];

        while (k -- > 0){
            int min = -1;
            int use = -1;

            for (int i = 0; i < length; i++){
                int index = offset[i];
                if(index >= matrix.length){
                    continue;
                }

                int curNum = matrix[index][i];
                if(use == -1){
                    use = i;
                    min = curNum;
                    continue;
                }else {
                    if(curNum <= min){
                        use = i;
                        min = curNum;
                    }
                }
            }

            offset[use] ++;
            if(k == 0){
                return min;
            }
        }

        return Integer.MIN_VALUE;
    }
}
