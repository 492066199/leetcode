package com.sailing.leetcode.solution378;

import java.util.PriorityQueue;

public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix[0].length;
        int[] offset = new int[length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //init
        for (int i = 0; i < offset.length; i++){
            minHeap.add(new int[]{matrix[0][i], i});
        }



        while (k -- > 0){
            int[] pair = minHeap.poll();
            if(k == 0){
                return pair[0];
            }else {
                offset[pair[1]] ++;
                if(offset[pair[1]] >= matrix.length){
                    continue;
                }else {
                    minHeap.add(new int[]{matrix[offset[pair[1]]][pair[1]], pair[1]});
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    static class Pair{
        int x;
        int index;

        public Pair(int x, int index) {
            this.x = x;
            this.index = index;
        }
    }
}
