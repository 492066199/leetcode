package com.sailing.leetcode.solution149;

import java.util.*;

/**
 * Created by yangyang on 2018/3/8.
 * beat 88%
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 1){
            return points.length;
        }
        Point[] points1 = new Point[points.length];
        int[] chongfu = new int[points.length];
        Map<String, Integer> sorted = new HashMap<String, Integer>();
        int index = 0;
        for(Point p : points){
            String skey = p.x + "#" + p.y;
            Integer click = sorted.get(skey);
            if(click == null) {
                points1[index] = p;
                sorted.put(skey, index);
                index ++;
            }else {
                chongfu[click] ++;
            }
        }
        int length = sorted.size();
        Map<String, int[]> rs = new HashMap<String, int[]>();
        int max = 0;
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                String key = calc(points1[i], points1[j]);
                int[] c = rs.get(key);
                if(c == null){
                    c = new int[length];
                    rs.put(key, c);
                }

                c[i] = 1;
                c[j] = 1;
            }
        }

        if(length == 1){
            rs.put("", new int[]{1});
        }

        for (int[] b : rs.values()){
            int h = getmaxFrom(b, chongfu);
            if(h > max){
                max = h;
            }
        }
        return max;
    }

    private int getmaxFrom(int[] b, int[] chongfu) {
        int c = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] > 0){
                c = c + b[i] + chongfu[i];
            }
        }
        return c;
    }

    private String calc(Point point, Point point1) {
        if(point.x == point1.x){
            return point.x + "x";
        }
        if(point.y == point1.y){
            return point.y + "y";
        }
        int xdiff = point1.x - point.x;
        int ydiff = point1.y - point.y;

        int nb = xdiff * point1.y - ydiff * point1.x;
        int a = xdiff;
        int b = ydiff;
        int c = nb;
        if(a < 0){
            a = -a;
            b = -b;
            c = -c;
        }

        int zuix = gongyue(a, b);
        if(zuix != 1) {
            int zuix1 = gongyue(a, c);
            int kid = Math.min(zuix, zuix1);
            if(kid != 1 && kid != 0) {
                a = a / kid;
                b = b / kid;
                c = c / kid;
            }
        }

        return a + "#" + b + "#" + c;
    }

    public int gongyue(int a, int b) {
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int newone = 0;
        if (a > b){
            int mod = a / b;
            newone = a - b * mod;
        }else{
            int mod = b / a;
            newone = b - a * mod;
        }

        int d = Math.min(a, b);
        return gongyue(newone, d);
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
