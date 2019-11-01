package com.sailing.leetcode.solution73;

public class Solution {
    boolean firstRow = false,firstColumn = false;

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        if(matrix[0][0] == 0){
            firstColumn = true;
            firstRow = true;
        }

        //check first
        for(int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstColumn = true;
            }
        }

        for (int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                firstRow = true;
            }
        }

        //check other
        for (int i = 1; i < matrix.length; i ++){
            checkRow(matrix[i]);
        }

        for (int i = 1; i < matrix[0].length; i++){
            checkColumn(matrix, i);
        }

        //fill first
        for(int i = 1; i < matrix.length; i ++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i= 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        // fill other
        if(firstColumn){
            for(int i = 0; i < matrix.length; i++){
                 matrix[i][0] = 0;
            }
        }

        if(firstRow){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }

    private void checkColumn(int[][] matrix, int i) {
        for(int j = 1; j < matrix.length; j ++){
            if(matrix[j][i] == 0){
                matrix[0][i] = 0;
                break;
            }
        }
    }

    private void checkRow(int[] row) {
        for (int i= 1; i < row.length; i++){
            if(row[i] == 0){
                row[0] = 0;
                break;
            }
        }
    }
}
