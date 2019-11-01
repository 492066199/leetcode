package com.sailing.leetcode.solution211;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordDictionary {
    private Node dic;
    private Set<Integer> b1ooleam = new HashSet<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
        dic = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        b1ooleam.add(word.length());
        Node cur = dic;
        for (int pos = 0; pos < word.length(); pos ++){
            boolean isEnd = (pos == word.length() - 1);
            int index = word.charAt(pos) - 'a';
            if(!cur.flag[index]){
                cur.has.add(index);
                cur.flag[index] = true;
            }

            if(cur.childern[index] == null){
                cur.childern[index] = new Node();
            }

            if(isEnd){
                cur.childern[index].leaf = true;
                return;
            }

            cur = cur.childern[index];
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(b1ooleam.contains(word.length())) {
            return searchMore(0, word, dic);
        }else {
            return false;
        }
    }

    private boolean searchMore(int pos, String word, Node p) {
        char c = word.charAt(pos);
        boolean isEnd = (pos == word.length() - 1);
        if(c == '.'){
            //search all
            for(Integer index : p.has){
                if(isEnd){
                    if(p.childern[index].leaf){
                        return true;
                    }
                }else if(searchMore(pos + 1, word, p.childern[index])){
                    return true;
                }
            }
        }else {
            Node cur = p.childern[c - 'a'];
            if(cur == null){
                return false;
            }else {
                if(isEnd){
                    return cur.leaf;
                }else {
                    return searchMore(pos + 1, word, cur);
                }
            }
        }
        return false;
    }

    public static class Node{
        public Node[] childern = new Node[27];
        public boolean leaf = false;
        public boolean[] flag = new boolean[26];
        public List<Integer> has = new ArrayList<>();
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));// -> false
        System.out.println(obj.search("bad"));// -> true
        System.out.println(obj.search(".ad"));// -> true
        System.out.println(obj.search("b.."));// -> true
    }
}
