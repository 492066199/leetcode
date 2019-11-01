package com.sailing.leetcode.solution240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        R r = find(matrix , target, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return r.find;
    }

    private R find(int[][] matrix, int target, int top, int bottom, int left, int right) {
        if(left > right || top > bottom){
            return new R();
        }
        if(matrix[top][left] > target){
            return new R();
        }
        R lr_r = findlr(matrix, left, right, top, target);
        if(lr_r.find){
            return lr_r;
        }
        R tb_r = findtn(matrix, top, bottom, lr_r.y, target);
        if(tb_r.find){
            return tb_r;
        }

        int y = lr_r.y;
        int x = tb_r.x;
        //
        R rt = find(matrix, target, top, x - 1, y + 1, right);
        if(rt.find){
            return rt;
        }
        R lb = find(matrix, target, x + 1, bottom, left, y - 1);
        return lb;
    }

    private R findtn(int[][] matrix, int top, int bottom, int y, int target) {
        if(top == bottom) {
            R r = new R();
            if (matrix[top][y] == target){
                r.find = true;
                return r;
            }else {
                r.find = false;
                r.x = top;
                r.y = y;
                return r;
            }
        }
        int mid = (bottom + top)/2;
        if(matrix[mid][y] > target){
            return findtn(matrix, top, mid - 1, y, target);
        }else if(matrix[mid][y] < target){
            if(matrix[mid + 1][y] < target){
                return findtn(matrix, mid + 1, bottom, y, target);
            }else if(matrix[mid + 1][y] > target){
                R r = new R();
                r.find = false;
                r.x = mid;
                r.y = y;
                return r;
            }
        }
        R r = new R();
        r.find = true;
        return r;
    }

    private R findlr(int[][] matrix, int left, int right, int x, int target) {
        int[] nums = matrix[x];
        if(left == right) {
            R r = new R();
            if (nums[left] == target){
                r.find = true;
                return r;
            }else {
                r.find = false;
                r.x = x;
                r.y = left;
                return r;
            }
        }
        int mid = (left + right)/2;
        if(nums[mid] > target){
            return findlr(matrix, left, mid - 1, x, target);
        }else if(nums[mid] < target){
            if(nums[mid + 1] < target){
                return findlr(matrix, mid + 1, right, x, target);
            }else if(nums[mid + 1] > target){
                R r = new R();
                r.find = false;
                r.x = x;
                r.y = mid;
                return r;
            }
        }
        R r = new R();
        r.find = true;
        return r;
    }

    public static class R{
        public boolean find;
        public int x;
        public int y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{ -1},{ - 1}}, 0));
    }
}
