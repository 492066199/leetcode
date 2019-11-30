package com.sailing.leetcode.solution363;

import java.util.TreeSet;

/***
 * @date 2019-11-30 13:38
 * @author sailingYang
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        //for sum
        //m * n
        for (int i = 0; i < matrix.length; i++){
            for (int j = 1; j < matrix[i].length; j++){
                matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        //use i as the start(include)
        for (int i = 0; i < matrix[0].length; i ++){
            //use j as the end(include)
            for (int j = i; j < matrix[0].length; j ++){
                //find max num
                int sum = 0;
                TreeSet<Integer> sorted = new TreeSet<>();

                //if we use m as end
                for (int m = 0; m < matrix.length; m++){
                    int cur = matrix[m][j];
                    if(i != 0){
                        cur = matrix[m][j] - matrix[m][i - 1];
                    }

                    sum = sum + cur;
                    //if we use all!
                    if(sum <= k){
                        max = Math.max(sum, max);
                    }

                    //else we use sub
                    // sum - remain <= k
                    // sum - k <= remain
                     int remain = sum - k;

                    //true tmp >= remain
                    Integer tmp = sorted.ceiling(remain);
                    if(tmp != null){
                         int curmax = sum - tmp;
                         max = Math.max(curmax, max);
                    }

                    sorted.add(sum);
                }
            }
        }

        return max;
    }
}
