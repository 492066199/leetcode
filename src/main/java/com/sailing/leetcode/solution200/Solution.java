package com.sailing.leetcode.solution200;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    fillAll(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void fillAll(int i, int j, char[][] grid) {
        if(0 <= i && i < grid.length && 0 <= j && j < grid[i].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            fillAll(i, j + 1, grid );
            fillAll(i, j - 1, grid );
            fillAll(i + 1, j, grid );
            fillAll(i - 1, j, grid );
        }
    }
}
