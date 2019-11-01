package com.sailing.leetcode.solution212;

import java.util.*;

public class Solution {
    Set<String> failed = new HashSet<>();
    int max = 0;
    public List<String> findWords(char[][] board, String[] words) {
        Map<Integer, Set<Ponit>> cache = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int c = board[i][j];
                Set<Ponit> sp = cache.get(c);
                if(sp == null){
                    sp = new HashSet<>();
                    cache.put(c, sp);
                }
                sp.add(new Ponit(i, j));
            }
        }

        List<String> find = new ArrayList<>();
        Set<String> has = new HashSet<>();
        boolean[][] plate = new boolean[board.length ][board[0].length];
        for (String word : words){
            boolean c = false;

            for(String f : failed){
                if(word.startsWith(f)){
                    c = true;
                    break;
                }
            }

            if(c){
                continue;
            }

            if(has.contains(word)){
                continue;
            }
            if(check(word, plate, cache, board)){
                find.add(word);
                has.add(word);
            }else {
                failed.add(word.substring(0, max + 1));
                max = 0;
            }
            clear(plate);
        }
        return find;
    }

    private void clear(boolean[][] plate) {
        for(int i = 0; i < plate.length; i++){
            for(int j = 0; j < plate[i].length; j++){
                plate[i][j] = false;
            }
        }
    }

    private boolean check(String word, boolean[][] plate, Map<Integer, Set<Ponit>> cache, char[][] board) {
        int c = word.charAt(0);
        Set<Ponit> ponits = cache.get(c);
        if(ponits == null){
            return false;
        }else {
            for(Ponit ponit : ponits) {
                plate[ponit.i][ponit.j] = true;
                if(trasel(ponit, word, plate, 1, board)){
                   return true;
                }
                plate[ponit.i][ponit.j] = false;
            }
            return false;
        }
    }

    private boolean trasel(Ponit ponit, String word, boolean[][] plate, int index, char[][] board) {
        if (index == word.length()){
            return true;
        }else {
            int c = word.charAt(index);
            List<Ponit> ps = ponit.getNears(plate, board, c);
            if(ps.size() == 0){
                max = Math.max(max, index);
                return false;
            }else {
                for(Ponit p : ps){
                    plate[p.i][p.j] = true;
                    if(trasel(p, word, plate, index + 1, board)){
                        return true;
                    }
                    plate[p.i][p.j] = false;
                }
            }
        }

        return false;
    }

    public static class Ponit{
        public Ponit(int i, int j){
            this.i = i;
            this.j = j;
        }
        public int i;
        public int j;

        public List<Ponit> getNears(boolean[][] plate, char[][] board, int c) {
            List<Ponit> r = new ArrayList<>();
            //fornt
            if(i - 1 >= 0 && !plate[i - 1][j] && board[i - 1][j] == c){
                r.add(new Ponit(i -1 , j));
            }

            //bottom
            if(i + 1<= plate.length - 1 && !plate[i + 1][j] && board[i + 1][j] == c){
                r.add(new Ponit(i + 1 , j));
            }

            //left
            if(j - 1 >= 0 && !plate[i][j - 1] && board[i][j - 1] == c){
                r.add(new Ponit(i, j - 1));
            }

            //right
            if(j + 1 <= plate[i].length - 1 && !plate[i][j + 1] && board[i][j + 1] == c){
                r.add(new Ponit(i, j + 1));
            }

            return r;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findWords(new char[][]{{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}},
                new String[]{"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"}));
    }
}
