package com.sailing.leetcode.solution51;

import java.util.*;


public class Solution {
    List<List<Integer>> tr = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        fill(grid, 0, new LinkedList<>());

        List<List<String>> r = new ArrayList<>();
        for(List<Integer> t : tr){
            r.add(transferTo(t));
        }
        return r;
    }

    private List<String> transferTo(List<Integer> t) {
        List<String> r = new ArrayList<>();

        for(int i = 0; i < t.size(); i++){
            StringBuilder sb = new StringBuilder(t.size() * 2);
            for (int j = 0; j < t.size(); j++){
                if(t.get(j) == i){
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            r.add(sb.toString());
        }
        return r;
    }

    private void fill(boolean[][] grid, int column, LinkedList<Integer> cur) {
        // find r;
        if(column == grid.length){
            tr.add(new ArrayList<>(cur));
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
        System.out.println(new Solution().solveNQueens(4));
    }
}
