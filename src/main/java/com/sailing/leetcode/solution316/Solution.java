package com.sailing.leetcode.solution316;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int k = s.length() / 26 + 1;
        List<Integer>[] cache = new List[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(cache[index] == null){
                cache[index] = new ArrayList<>(k);
                count++;
            }
            cache[index].add(i);
        }
        
        boolean[] used = new boolean[26];
        String c = find(s, cache, 0, used, count);

        return c;
    }

    private String find(String s, List<Integer>[] cache, int start, boolean[] used, int count) {
        if(count == 0){
            return "";
        }
        boolean range = false;
        int offset = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = start; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(used[index]){
                continue;
            }
            //uniq
            if(cache[index].size() == 1){
                range = true;
            //double
            }else {
                if(cache[index].get(cache[index].size() - 1) <= i){
                    range = true;
                }
            }

            if(s.charAt(i) < min){
                offset = i;
                min = s.charAt(i);
            }

            if(range)
                break;
        }

        for(int i = 0; i < 26; i++) {
            if(cache[i] == null){
                continue;
            }
            remove(cache, offset, i);
        }

        if(count == 1){
            return (char)min + "";
        }

        //use k as the new start
        used[min - 'a'] = true;
        String c = find(s, cache, offset + 1, used, count - 1);

        return (char)min + c;
    }

    private void remove(List<Integer>[] cache, int j, int c) {
        List<Integer> ss = cache[c];
        int i = 0;
        for(;i < ss.size(); i++){
            if(ss.get(i) > j){
                break;
            }
        }
        cache[c] = ss.subList(i, ss.size());
    }

    public static void main(String[] args) {
        System.out.println("abcdefghjkiostmlpvwxzunqyr");
        System.out.println(new Solution().removeDuplicateLetters("heeh"));
        System.out.println(new Solution().removeDuplicateLetters("cruaebrnuzdmpfivugqejkspqvxxgnjixjtoboexjwcywzwptiahdbxkmhccsdnlmrmldwoxnurnlaiyzshimpzbmunvwhfkcvbeeorioxoxommgkjablxuibuxbuhhclgjwsgecuhvqscwutbownyjckhqlhjrdmtkozdwuewsxpupwhjeywznccjdeiisirvkvfroiyhhwuynmhwsdzmwauezxbssaxefktyufjnysvcmxrqxunoipqrbjxnxdwmeebpgucfxvvaansdpfetpipqynomtwkloczuepklwmhawfgovewnvxeqyghndlyoqxvoxwozfzprqwvcewvzjykyohfmywymudenrxwcoxrbsgctenzjxhqwtghlpnhkrjkxualiarouhscitxpmgabllajoqipvslibzxioocvvpdlwxvbvspezufenplebnajqsyixar"));
    }
}
