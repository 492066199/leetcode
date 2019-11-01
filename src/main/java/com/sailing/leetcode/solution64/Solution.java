package com.sailing.leetcode.solution64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyang on 2018/3/22.
 * 题目说的不可以向左 哎把题目理解难了
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},{3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},{6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},{4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},{7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},{8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},{8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},{5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},{0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},{4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},{5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},{0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},{1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},{1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},{8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},{9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},{3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},{1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},{3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}}));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int colimn = grid[0].length;
        Heap heap = new Heap(row, colimn, grid);
        int count = 0;
        int maxNim = row * colimn;
        while (count < maxNim) {
            Point p = heap.getMin();
            count ++;
            List<Point> nps = p.getNearst(p);
            for(Point np : nps){
                heap.shrink(p, np);
//                if(np.x == row - 1 && np.y == colimn - 1){
//                    return heap.getShortest(np.x, np.y);
//                }
            }
        }
        dispaly(heap);
        return heap.getShortest(row - 1, colimn - 1);
    }

    private void dispaly(Heap heap) {
        for(int i = 0; i < heap.row; i ++){
            for(int j = 0; j < heap.column; j++){
                System.out.print(heap.grid[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }

        for(int i = 0; i < heap.row; i ++){
            for(int j = 0; j < heap.column; j++){
                System.out.print(heap.pmap[i][j].path);
                System.out.print(',');
            }
            System.out.println();
        }
    }

    static class Heap{
        int remain;
        Point[][] pmap;
        boolean flag[][];
        int[][] grid;
        int length = 0;
        int row;
        int column;
        public Heap(int row, int column, int[][] grid) {
            this.row = row;
            this.column = column;
            pmap = new Point[row][column];
            length = row * column;
            remain = length;
            this.grid = grid;
            flag = new boolean[row][column];
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < column; j ++){
                    pmap[i][j] = new Point(this, i, j);
                }
            }

            pmap[0][0].path = this.grid[0][0];
        }

        public Point getMin(){
            Point min = null;
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < column; j ++){
                    if(!flag[i][j]) {
                        if (min == null) {
                            min = pmap[i][j];
                        } else {
                            if (pmap[i][j].path < min.path) {
                                min = pmap[i][j];
                            }
                        }
                    }
                }
            }
            flag[min.x][min.y] = true;
            return min;
        }

        public void shrink(Point p, Point np) {
            if(np.path == Integer.MAX_VALUE){
                np.path = p.path + grid[np.x][np.y];
                return;
            }
            int c = this.grid[np.x][np.y] + p.path;
            if(c < np.path){
                np.path = c;
            }
        }

        public int getShortest(int row, int column) {
            return pmap[row][column].path;
        }
    }

    static class Point{
        Heap heap;
        public int path = Integer.MAX_VALUE;
        final public int x;
        final public int y;

        public Point(Heap heap, int x, int y) {
            this.x = x;
            this.y = y;
            this.heap = heap;
        }

        public List<Point> getNearst(Point p) {
            List<Point> ps = new ArrayList<>(4);
            //
            int x = p.x;
            int y = p.y + 1;
            checkAndAdd(x, y, ps);
            //
            x = p.x;
            y = p.y - 1;
            checkAndAdd(x, y, ps);
            //
            x = p.x + 1;
            y = p.y;
            checkAndAdd(x, y, ps);
            //
            x = p.x - 1;
            y = p.y;
            checkAndAdd(x, y, ps);

            return ps;
        }

        private void checkAndAdd(int x, int y, List<Point> ps) {
            if(x < 0 || x >= this.heap.row){
                return;
            }

            if(y < 0 || y >= this.heap.column){
                return;
            }

            if(heap.flag[x][y]){
                return;
            }

            ps.add(heap.pmap[x][y]);
        }
    }
}
