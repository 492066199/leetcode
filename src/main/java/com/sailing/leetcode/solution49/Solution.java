package com.sailing.leetcode.solution49;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        }

        int[] wordTable = new int[26];
        Map<String, List<String>> keyStringListMap = new HashMap<>();
        for(String str : strs){
            String key = generateKey(str, wordTable);
            List<String> stringList = keyStringListMap.get(key);
            if(stringList == null){
                stringList = new ArrayList<>();
                keyStringListMap.put(key, stringList);
            }

            stringList.add(str);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(keyStringListMap.values());
        return result;
    }

    private String generateKey(String str, int[] wordTable) {

        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            wordTable[index] ++;
        }
        StringBuilder sb = new StringBuilder(26 * 2 + 2);
        for(int i = 0; i < 26; i++){
            sb.append(wordTable[i]).append('#');
            wordTable[i] = 0;
        }
        return sb.toString();
    }
}
