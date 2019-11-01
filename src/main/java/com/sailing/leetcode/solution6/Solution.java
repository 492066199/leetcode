package com.sailing.leetcode.solution6;

/***
 * 2018-03-17
 * 有时间再来刷
 * 题目总是让人误解
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (numRows == 1 || s.length() == 1) {
            return s;
        }

        char[][] point = new char[s.length()][numRows];
        int curRow = 0;
        int colum = 0;
        int maxRow = numRows;
        int start = 0;
        boolean add = false;
        int maxcolumn = 0;
        boolean dir = true;
        for (int i = 0; i < s.length(); i++) {
            point[colum][curRow] = s.charAt(i);
            if(dir) {
                curRow++;
            }else {
                curRow--;
            }
            maxcolumn = colum;
            if (curRow == maxRow || curRow == start - 1) {
                colum++;
                int c = 0;
                if (maxRow - start == 1 || maxRow - start == 2) {
                    add = true;
                    c++;
                }

                if (maxRow - start == numRows) {
                    add = false;
                    c++;
                }

                if (c == 2) {
                    curRow = start;
                    continue;
                }

                if (!add) {
                    start++;
                    maxRow = maxRow - 1;
                } else {
                    start--;
                    maxRow = maxRow + 1;
                }

                if(dir){
                    curRow = maxRow - 1;
                }else {
                    curRow = start;
                }
                dir = !dir;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < maxcolumn + 1; j++) {
                char t = point[j][i];
                if (t == 0) {
                    sb.append(' ');
                } else {
                    sb.append(t);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 5));
    }
}
