package com.sailing.leetcode.solution64;

/**
 * beat 99%
 * yangyang
 * 2018-03-23
 */
public class Solution1 {

    int cache[][] = null;
    boolean flag[][] = null;
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        cache = new int[row][column];
        flag = new boolean[row][column];
        return travel(grid, row - 1, column - 1);
    }


    private int travel(int[][] grid, int row, int column) {
        if(flag[row][column]){
            return cache[row][column];
        }

        if(row == 0 && column == 0){
            cache[row][column] = grid[0][0];
            flag[row][column] = true;
            return grid[0][0];
        }

        if(row == 0){
            int c = 0;
            for(int j = 0; j <= column; j++){
                c = grid[0][j] + c;
                cache[row][j] = c;
                flag[row][j] = true;
            }

            return cache[row][column];
        }

        if(column == 0){
            int c = 0;
            for(int j = 0; j <= row; j++){
                c = grid[j][0] + c;
                cache[j][0] = c;
                flag[j][0] = true;
            }
            return cache[row][column];
        }

        int c = travel(grid, row - 1, column);
        int c1 = travel(grid, row, column - 1);
        int o = Math.min(c, c1) + grid[row][column];

        cache[row][column] = o;
        flag[row][column] = true;
        return o;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().minPathSum(new int[][]{{1,2},{5,6},{1,1}}));
    }
}
