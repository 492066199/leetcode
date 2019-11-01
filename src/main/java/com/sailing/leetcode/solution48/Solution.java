package com.sailing.leetcode.solution48;

/***
 * yangyang
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }

        if(matrix.length == 1){
            return;
        }

        int hop = matrix.length / 2;
        for(int base = 0;hop > 0 ;hop --,base ++){
            int left = base;
            int top = base;
            int bottom = matrix.length - 1 - base;
            int right = matrix.length - 1 - base;
            rotateCube(matrix, left, right, top, bottom);
        }
    }

    /**      top
     *      ****  {}[0][x]
     * left *  *  {}[1][x] right
     *      *  *  {}[2][x]
     *      ****  {}[3][x]
     *       bottom
     * @param matrix
     * @param left
     * @param right
     * @param top
     * @param bottom
     */
    private void rotateCube(int[][] matrix, int left, int right, int top, int bottom) {
        int edgeLength = right - left + 1;
        if(edgeLength == 1){
            return;
        }
        for(int i = left; i < right; i++){
            //
            int span = i - left;

            //top rotate
            int tmp = matrix[top][i];

            //left rotate
            int leftNewY =  bottom - span;
            matrix[top][i] = matrix[leftNewY][left];

            //bottom rotate
            int bottomNewX = right - span;
            matrix[leftNewY][left] = matrix[bottom][bottomNewX];

            //right rotate
            int rightNewY = top + span;
            matrix[bottom][bottomNewX] = matrix[rightNewY][right];

            //last top rotate over
            matrix[rightNewY][right] = tmp;
        }
    }

    public static void main(String[] args) {
        /***
         * 1 2
         * 3 4
         */
        int [][] testdata = new int[][]{{1,2},{3,4}};
        new Solution().rotate(testdata);
        System.out.println(testdata[0][0]);
        System.out.println(testdata[0][1]);
        System.out.println(testdata[1][0]);
        System.out.println(testdata[1][1]);
    }
}
