package com.sailing.leetcode.solution130;



import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        if(board.length == 1){
            return;
        }

        boolean[][] checked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!checked[i][j]) {
                    if (board[i][j] == 'X') {
                        continue;
                    } else {
                        Set<String> sign = new HashSet<>();
                        //only O can bfs
                        boolean r = bfs(i, j, sign, board, checked);
                        if (!r) fill(sign, board);
                    }
                }
            }
        }
    }

    private void fill(Set<String> sign, char[][] board) {
        for(String s : sign){
            int pos = 0;
            for (int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ' '){
                    pos = i;
                }
            }
            int x = Integer.parseInt(s.substring(0, pos));
            int y = Integer.parseInt(s.substring(pos + 1, s.length()));
            board[x][y] = 'X';
        }
    }

    private boolean bfs(int i, int j, Set<String> sign, char[][] board, boolean[][] checked) {
        String tag = i + " " + j;
        if(sign.contains(tag)){
            return false;
        }else {
            sign.add(tag);
            checked[i][j] = true;
        }

        boolean canLive = checkCanlive(i, j, board);

        // 1
        int x = i;
        int y = j + 1;
        if(x >= 0 && x < board.length &&y >= 0 && y < board[x].length){
            if(board[x][y] == 'O')
                canLive = canLive || bfs(x, y, sign, board, checked);
        }

        //2
        x = i;
        y = j - 1;
        if(x >= 0 && x < board.length &&y >= 0 && y < board[x].length ){
            if(board[x][y] == 'O')
                canLive = canLive || bfs(x, y, sign, board, checked);
        }

        //3
        x = i - 1;
        y = j;
        if(x >= 0 && x < board.length && y >= 0 && y < board[x].length){
            if(board[x][y] == 'O')
                canLive = canLive || bfs(x, y, sign, board, checked);
        }

        //4
        x = i + 1;
        y = j;
        if(x >= 0 && x < board.length && y >= 0 && y < board[x].length){
            if(board[x][y] == 'O')
                canLive = canLive || bfs(x, y, sign, board, checked);
        }

        return canLive;
    }

    private boolean checkCanlive(int i, int j, char[][] board) {
        if(i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] test = new char[1][1];
        test[0][0] = 'X';
        System.out.println();
        new Solution().solve(test);
    }
}
