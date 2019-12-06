package com.sailing.leetcode.solution373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/***
 *
 * PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
 */
public class Solution1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0){
            return new ArrayList<>();
        }

        /***
         * state!
         *     0 1 2 3(nums1)
         *   0 Y - - -
         *   1 - - - -
         *   2 - - - -
         *   3 - - - -
         * (nums2)
         */

        //init
        List<List<Integer>> rs = new ArrayList<>();
        int state[] = new int[nums1.length];
        /***
         * use 0 as the value
         * use 1 as the index
         *
         */
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)->a[0]-b[0]);
        //init sorted list
        // the 0 row
        for (int i = 0;i < nums1.length; i++){
            que.add(new int[]{ nums1[i] + nums2[0],i});
        }

        int count = 0;
        while (count < k){
            int[] cur = que.poll();
            if(cur == null){
                break;
            }else {
                int column_use = cur[1];
                int x = nums1[column_use];
                int y = nums2[state[column_use]];

                rs.add(Arrays.asList(x, y));
                count ++;
                state[column_use] ++;

                if(state[column_use] < nums2.length){
                    que.offer(new int[]{x + nums2[state[column_use]], column_use});
                }
            }
        }
        return rs;
    }



    public static void main(String[] args) {
        System.out.println(new Solution1().kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
}
