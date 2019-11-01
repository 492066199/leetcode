package com.sailing.leetcode.solution74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0].length == 0 || matrix[0][0] > target){
            return false;
        }

        int row = findRow(matrix, 0, matrix.length - 1, target);
        if(row == -1){
            return false;
        }
        int column[] = matrix[row];
        return findtarget(column, 0, column.length - 1, target);
    }

    private boolean findtarget(int[] column, int start, int end, int target) {
        if(start > end){
            return false;
        }

        if(start == end){
            if (column[start] == target){
                return true;
            }else {
                return false;
            }
        }

        int mid = (start + end) / 2;
        if(column[mid] == target){
            return true;
        }else if(column[mid] > target){
            return findtarget(column, start, mid - 1, target);
        }else {
            return findtarget(column, mid + 1, end, target);
        }
    }

    private int findRow(int[][] matrix, int start, int end, int x) {
        if(start == end){
            return start;
        }

        int mid = (start + end) / 2;
        if(matrix[mid][0] == x){
            return mid;
        }else if(x < matrix[mid][0]){
            return findRow(matrix, start,mid - 1, x);
        }else {
            int incrMid = mid + 1;
            if(incrMid > matrix.length - 1){
                return incrMid;
            }else {
                int incrMidValue = matrix[incrMid][0];
                if(incrMidValue == x){
                    return mid + 1;
                }else if(incrMidValue < x){
                    return findRow(matrix, incrMid, end, x);
                }else {
                    return mid;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},
        13));
    }
}
