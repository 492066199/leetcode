package com.sailing.leetcode.solution628;


/***
 *
 * relax
 *
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int [] max  = new int[3];

        int [] min = new int[3];

        boolean r = false;

        for (int num : nums){
            if(num > 0){
                if(num >= max[0]){
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = num;
                }else if(num >= max[1]){
                    max[2] = max[1];
                    max[1] = num;
                }else if(num > max[2]){
                    max[2] = num;
                }
            }else if(num < 0){
                if(num <= min[0]){
                    min[2] = min[1];
                    min[1] = min[0];
                    min[0] = num;
                }else if(num <= min[1]){
                    min[2] = min[1];
                    min[1] = num;
                }else if(num < min[2]){
                    min[2] = num;
                }
            }else {
                r = true;
            }
        }

        if(max[0] == 0){
            if(r){
                return 0;
            }else {
                max[2] = max[1] = max[0] = Integer.MIN_VALUE;
                //find max three
                for (int num : nums) {
                    if (num >= max[0]) {
                        max[2] = max[1];
                        max[1] = max[0];
                        max[0] = num;
                    } else if (num >= max[1]) {
                        max[2] = max[1];
                        max[1] = num;
                    } else if (num > max[2]) {
                        max[2] = num;
                    }
                }

                return max[0] * max[1] * max[2];
            }
        }else if(max[1] == 0){
            if(min[0] == 0){
                return 0;
            }else if(min[1] == 0){
                return 0;
            }else{
                return min[0] * min[1] * max[0];
            }
        //two positive
        }else if(max[2] == 0){
            //no negative
            if(min[0] == 0){
                return 0;
            //one negative
            }else if(min[1] == 0){
                if(r) {
                    return 0;
                }else {
                    return min[0] * max[0] * max[1];
                }
            //two posive two negative
            }else{
                return min[0] * min[1] * max[0];
            }
        //three positive
        }else {
            //no negative
            if(min[0] == 0){
                return max[0] * max[1] * max[2];
                //one negative
            }else if(min[1] == 0){
                return min[0] * max[0] * max[1];
                //two posive two negative
            }else{
                return Math.max(min[0] * min[1] * max[0], max[0] * max[1] * max[2]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().maximumProduct(new int[]{-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,-462,694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,338,-20,-890,-819,-644,107,404,150,-219,459,-324,-385,-118,-307,993,202,-147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,-350,-948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,-563,-766,-837,-333,93,893,303,908,532,-206,990,280,826,-13,115,-732,525,-939,-787})
        );
    }
}
