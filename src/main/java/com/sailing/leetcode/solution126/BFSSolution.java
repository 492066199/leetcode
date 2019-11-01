package com.sailing.leetcode.solution126;

import java.util.*;

/**
 * yangyang 2018-3-10
 * beat 80% bfs in no weight graph
 */
public class BFSSolution {
    List<List<String>> result[] = null;
    List<String> words;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> graphList = buildgraphList(beginWord, endWord, wordList);
        if(graphList == null || graphList.size() == 0){
            return new ArrayList<>();
        }
        words = graphList;
        //init
        result = new List[wordList.size()];
        //build graph
        Matrix matrix = buildGraph(graphList);

        //find start end offset
        int start = graphList.size() - 1;
        int end = graphList.size() - 2;

        //find
        findShortestPath(start, end, matrix);
        List<List<String>> sssr = getResult(end);
        return sssr;
    }

    private List<String> buildgraphList(String beginWord, String endWord, List<String> wordList) {
        int start = -1;
        int end = -1;
        for(int i = 0; i < wordList.size(); i++ ){
            String word = wordList.get(i);
            if(word.equals(beginWord)){
                start = i;
            }
            if(word.equals(endWord)){
                end = i;
            }
        }
        if(start != -1){
            wordList.remove(start);
        }

        if(end == -1){
            return null;
        }
        if(start != -1 && start < end){
            end --;
        }

        wordList.remove(end);
        wordList.add(endWord);
        wordList.add(beginWord);
        return wordList;
    }

    private void findShortestPath(int start, int end, Matrix matrix) {
        boolean[] has = new boolean[matrix.pnum];
        Set<Integer> startSet = new HashSet<>();
        startSet.add(start);
        has[start] = true;

        List<List<String>> ss = getResult(start);
        List<String> tmpPath = new ArrayList<>(200);
        tmpPath.add(words.get(start));
        ss.add(tmpPath);

        nextHopSet(startSet, end, matrix, has);
    }

    private void nextHopSet(Set<Integer> start, int end, Matrix matrix, boolean[] has) {
        if(start.size() == 0){
            return;
        }
        boolean done = false;
        Set<Integer> nexthopStart = new HashSet<>();
        for(Integer source : start){
            Set<Integer> nears = matrix.getNearWord(source);
            List<List<String>> ss = getResult(source);
            for(Integer near : nears){
                if(near == end){
                    done = true;
                }

                if(!has[near]){
                    nexthopStart.add(near);
                    for(List<String> pathhalf : ss){
                        List<String> newp = new ArrayList<>(pathhalf);
                        newp.add(words.get(near));
                        getResult(near).add(newp);
                    }
                }
            }
        }

        for(Integer next : nexthopStart){
            has[next] = true;
        }

        if(done)
            return;
        else {
            nextHopSet(nexthopStart, end, matrix, has);
        }
    }

    public List<List<String>> getResult(int index){
        List<List<String>> ss = result[index];
        if(ss == null){
            result[index] = new LinkedList<>();
        }
        return result[index];
    }


    private Matrix buildGraph(List<String> wordList) {
        int length = wordList.get(0).length();
        Matrix matrix = new Matrix(wordList.size(), length, wordList);
        return matrix;
    }

    //use graph
    static class Matrix{
        private String x[];
        int pnum;
        int length;
        List<String> wordList;
        Map<String, Set<Integer>> quickMap = new HashMap<>();

        public Matrix(int ponitNum, int length, List<String> wordList){
            this.wordList = wordList;
            this.pnum = ponitNum;
            this.length = length;
            x = new String[ponitNum * length];
            initquickMap();
        }

        public Set<Integer> getNearWord(int wordk){
            int start = wordk * length;
            Set<Integer> rs = new HashSet<>();
            for(int i = 0 ; i < length; i++){
                String tmp = x[start + i];
                Set<Integer> tmpSet = quickMap.get(tmp);
                if(tmpSet == null){
                    continue;
                }
                rs.addAll(tmpSet);
            }
            return rs;
        }

        private void initquickMap() {
            for(int k = 0; k < pnum; k++){
                String word = wordList.get(k);
                for(int i = 0 ; i < length; i++){
                    StringBuilder sb = new StringBuilder(length + 2);
                    for(int j =0; j < length; j++){
                        if(i == j){
                            sb.append('#');
                        }else {
                            sb.append(word.charAt(j));
                        }
                    }
                    String tmp = sb.toString();
                    x[k * length + i] = tmp;
                    addQuickMap(tmp, k);
                }
            }
        }

        public void addQuickMap(String tmp, Integer k){
            Set<Integer> ss = quickMap.get(tmp);
            if(ss == null){
                ss = new HashSet<>();
                quickMap.put(tmp, ss);
            }
            ss.add(k);
        }

        public int num() {
            return pnum;
        }
    }
}
