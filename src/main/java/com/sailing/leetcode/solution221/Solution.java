package com.sailing.leetcode.solution221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] c = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                grow(c, matrix, i, j);
                max = Math.max(c[i][j], max);
            }
        }

        return max *max;
    }

    private void grow(int[][] c, char[][] matrix, int i, int j) {
        int count = 1;
        int x_p = i;
        int y_p = j;
        while (x_p < matrix.length && y_p < matrix[x_p].length) {
            for(int m = i; m <= x_p; m++){
                if (matrix[m][y_p] == '1'){
                    continue;
                }else {
                    return;
                }
            }

            for (int m = j; m <= y_p; m++){
                if(matrix[x_p][m] == '1'){
                    continue;
                }else {
                    return;
                }
            }

            c[i][j] = count;
            count++;
            x_p ++;
            y_p ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{{'1'}}));
    }
}
