package com.sailing.leetcode.solution63;

/**
 * Created by yangyang on 2018/3/23.
 * beat 99%
 */
public class Solution {
    int cache[][];
    boolean flag[][];
    int ori[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        ori = obstacleGrid;
        cache = new int[row][column];
        flag  = new boolean[row][column];
        
        return travel(row - 1, column - 1);
    }

    private int travel(int row, int column) {
        if(flag[row][column]){
            return cache[row][column];
        }

        if(ori[row][column]  == 1){
            flag[row][column] = true;
            cache[row][column] = 0;
            return 0;
        }

        if(row == 0){
            boolean r = false;
            for(int i = 0; i <= column; i++){
                if(ori[0][i] == 1){
                    r = true;
                }

                if(r){
                    cache[0][i] = 0;
                }else {
                    cache[0][i] = 1;
                }
                flag[0][i] = true;
            }
            return cache[0][column];
        }

        if(column == 0){
            boolean r = false;
            for(int i = 0; i <= row; i++){
                if(ori[i][0] == 1){
                    r = true;
                }

                if(r){
                    cache[i][0] = 0;
                }else {
                    cache[i][0] = 1;
                }
                flag[i][0] = true;
            }
            return cache[row][0];
        }

        int c = travel(row - 1, column);
        int c1 = travel(row, column - 1);
        int  o = c + c1;

        flag[row][column] = true;
        cache[row][column] = o;

        return o;
    }
}
