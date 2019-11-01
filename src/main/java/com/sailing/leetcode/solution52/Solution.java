package com.sailing.leetcode.solution52;

import java.util.LinkedList;

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        fill(grid, 0, new LinkedList<>());

        return count;
    }

    private void fill(boolean[][] grid, int column, LinkedList<Integer> cur) {
        // find r;
        if(column == grid.length){
            count ++;
            return;
        }

        for (int i = 0; i < grid.length; i++){
            //can choose i?
            if(canChoose(i, column, grid)){
                //choose
                cur.addLast(i);
                grid[i][column] = true;

                fill(grid, column + 1, cur);

                //clear, not choose!
                cur.removeLast();
                grid[i][column] = false;
                //can't
            }else {
                continue;
            }
        }
    }

    private boolean canChoose(int x, int column, boolean[][] grid) {
        int m = grid.length;
        //h
        for(int i = 0; i < grid.length; i++){
            if(grid[x][i]){
                return false;
            }
        }

        //v
        for(int i = 0; i < grid.length; i++){
            if(grid[i][column]){
                return false;
            }
        }

        //lefttop -> rightbottom
        int x1 = x + 1;
        int y1 = column + 1;
        while(isValid(x1 , y1, m)){
            if(grid[x1][y1]){
                return false;
            }
            x1 ++;
            y1 ++;
        }

        x1 = x - 1;
        y1 = column - 1;
        while(isValid(x1 , y1, m)){
            if(grid[x1][y1]){
                return false;
            }
            x1 --;
            y1 --;
        }

        //leftbottom -> righttop
        x1 = x - 1;
        y1 = column + 1;
        while(isValid(x1 , y1, m)){
            if(grid[x1][y1]){
                return false;
            }
            x1 --;
            y1 ++;
        }

        x1 = x + 1;
        y1 = column - 1;
        while(isValid(x1 , y1, m)){
            if(grid[x1][y1]){
                return false;
            }
            x1 ++;
            y1 --;
        }

        return true;
    }

    private boolean isValid(int x1, int y1, int n) {
        if(0 <= x1 && x1 < n && 0 <= y1 && y1< n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new com.sailing.leetcode.solution51.Solution().solveNQueens(4));
    }
}
