package com.sailing.leetcode.solution126;


import java.util.*;

/**
 *   yangyang 2018-03-10
 *   beat 54%
 *   
 */
public class Solution {

    List<String> result[] = null;
    List<String> words = null;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> graphList = buildgraphList(beginWord, endWord, wordList);
        words  = graphList;
        if(graphList == null || graphList.size() == 0){
            return new ArrayList<>();
        }
        //init
        result = new List[wordList.size()];
        //build graph
        Matrix matrix = buildGraph(graphList);

        //find start end offset
        int start = graphList.size() - 1;
        int end = graphList.size() - 2;

        //find
        findShortestPath(start, end, matrix);
        List<String> sssr = result[end];
        List<List<String>> ssr = new ArrayList<>(1000);
        if(sssr == null){
            return ssr;
        }
        for(String path : sssr){
            String[] pathnum = path.split(":");
            List<String> sr = new ArrayList<>(pathnum.length);
            for(String node : pathnum){
                sr.add(graphList.get(Integer.parseInt(node)));
            }
            ssr.add(sr);
        }
        return ssr;
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
        Shortest shortest = new Shortest(matrix.num());
        Set<Integer> ss = new HashSet<>();
        Set<Integer> remain = new HashSet<>();
        ss.add(start);

        for(int i = 0; i < start; i++){
            remain.add(i);
            shortest.setShort(i, Integer.MAX_VALUE);
        }

        Set<Integer> nearsStart = matrix.getNearWord(start);
        for(Integer nearIndex : nearsStart){
            shortest.setShort(nearIndex, 1);
            addPath(start, nearIndex);
        }

        while(ss.size() < matrix.pnum){
            int offset  = shortest.getMin(remain);
            if(shortest.get(offset) == Integer.MAX_VALUE){
                return ;
            }
            remain.remove(offset);
            ss.add(offset);

            if(offset == end){
                break;
            }

            Set<Integer> nears = matrix.getNearWord(offset);
            for(Integer r : nears) {
                if (!remain.contains(r)) {
                    continue;
                }
                int newshortest = shortest.get(offset) + 1;
                //收缩
                if (newshortest <= shortest.get(r)) {
                    List<String> paths = getResult(r);

                    if (newshortest < shortest.get(r)) {
                        paths.clear();
                    }

                    shortest.setShort(r, newshortest);

                    List<String> prepaths = getResult(offset);
                    for (String path : prepaths) {
                        String newPath = path + ":" + r;
                        paths.add(newPath);
                    }
                }
            }
        }
    }

    private void addPath(Integer start, Integer end) {
        List<String> ss = getResult(end);
        String tmpPath = start + ":" + end;
        ss.add(tmpPath);
    }

    public List<String> getResult(int index){
        List<String> ss = result[index];
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

    private static boolean hasEdge(String j, String i, int length) {
        int count = 0;
        for(int in = 0; in < length; in ++){
            if(j.charAt(in) == i.charAt(in)){

            }else {
                count ++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

    static class Shortest{
        int shortest[];
        TreeMap<Integer, Set<Integer>> so = new TreeMap<Integer, Set<Integer>>();

        public Shortest(int num){
            shortest = new int[num];
        }

        public void setShort(int offset, int value){
            shortest[offset] = value;
            addSort(offset, value);
        }

        public int get(int offset) {
            return shortest[offset];
        }

        private void addSort(int offset, int value){
            Set<Integer> offsets = so.get(value);
            if(offsets == null){
                offsets = new HashSet<>();
                so.put(value, offsets);
            }
            offsets.add(offset);
        }

        public int getMin(Set<Integer> remain){
            for(;;) {
                Map.Entry<Integer, Set<Integer>> low = so.firstEntry();
                if (low.getValue().size() == 0){
                    so.remove(low.getKey());
                    continue;
                }else {
                    Iterator<Integer> next = low.getValue().iterator();
                    Integer tmp = next.next();
                    next.remove();
                    return tmp;
                }
            }
        }
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
