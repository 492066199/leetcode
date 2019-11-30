package com.sailing.leetcode.solution367;


/***
 * @date 2019-11-30 14:29
 * @author sailing
 *
 */
public class Solution {
    public boolean isPerfectSquare(int num) {

        int start = 0;
        int end = Math.min(num, 46340);

        while (start <= end){
            if(start == end){
                return start * start == num;
            }

            if(start + 1 == end){
                return start* start == num || end * end == num;
            }

            int mid = (start + end)/2;
            int data = mid * mid;
            if(data < num){
                start = mid + 1;
            }else if(data > num){
                end = mid - 1;
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(46340 * 46340);
        System.out.println(new Solution().isPerfectSquare(16));
    }
}
