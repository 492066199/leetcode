package com.sailing.leetcode.solution69;

public class Solution {
    public int mySqrt(int x) {
        int r = find(x, 0, x);
        return r;
    }

    private int find(int x, int start, int end) {
        int mid = (start + end) / 2;
        int midRes = mid * mid;
        int k = mid;
        if(mid != 0) {
            k = midRes / mid;
        }
        System.out.println(mid + " --> " + k);
        if(midRes == x){
            return mid;
        }else if(midRes > x || k != mid){
            return find(x, start, mid - 1);
        }else {
            int incrRes = (mid + 1) * (mid + 1);
            int t = incrRes / (mid + 1);
            if(incrRes == x){
                return mid + 1;
            }else if(incrRes > x || t != (mid + 1)){
                return mid;
            }else{
                //incrRes < x
                return find(x, mid + 1, end);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(46340 * 46340);
        System.out.println(new Solution().mySqrt(2147483647));
    }
}
