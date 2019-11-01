package com.sailing.leetcode.solution208;

public class Trie {
    private Node[] root = new Node[26];

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node[] cur = root;
        for(int i = 0; i < word.length(); i ++){
            int index = word.charAt(i) - 'a';
            if(cur[index] == null){
                cur[index] = new Node();
                cur[index].cur = index;
            }
            if(i == word.length() - 1){
                cur[index].canLeaf = true;
                break;
            }

            cur = cur[index].childdren;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node[] cur = root;
        for(int i = 0; i < word.length(); i ++){
            int index = word.charAt(i) - 'a';

            if(cur[index] == null){
                return false;
            }

            if(i == word.length() - 1){
                return cur[index].canLeaf;
            }

            cur = cur[index].childdren;
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node[] cur = root;
        for(int i = 0; i < prefix.length(); i ++){
            int index = prefix.charAt(i) - 'a';

            if(cur[index] == null){
                return false;
            }

            if(i == prefix.length() - 1){
                return true;
            }

            cur = cur[index].childdren;
        }

        return true;
    }

    public static class Node{
        public int cur;
        public boolean canLeaf;
        public Node childdren[] = new Node[26];
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("app");
        boolean param_3 = obj.search("apple");
        boolean param_4 = obj.startsWith("app");

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
