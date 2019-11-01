package com.sailing.leetcode.solution210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        V[] graph = new V[numCourses];
        //init graph
        for(int i = 0; i < graph.length; i++){
            graph[i] = new V(i);
        }

        for (int i = 0; i < prerequisites.length; i ++){
            int [] pair = prerequisites[i];
            int course = pair[0];
            for(int j = 1; j < pair.length; j++){
                graph[course].need.add(pair[j]);
            }
        }

        List<Integer>[] total = new List[numCourses];

        boolean[] c_t = new boolean[graph.length];
        int[] r = new int[graph.length];
        int count = 0;

        Set<Integer> cur_path = new HashSet<>();
        for(int v = 0; v < graph.length; v++) {
            if(total[v] == null) {
                if (check(v, graph, total, cur_path) == null) {
                    return new int[0];
                }
            }

            for(Integer tmp : total[v]){
                if(!c_t[tmp]){
                    r[count] = tmp;
                    c_t[tmp] = true;
                    count ++;
                }
            }

            if(count == graph.length){
                break;
            }
        }

        return r;
    }

    private List<Integer> check(int v, V[] graph, List<Integer>[] total, Set<Integer> cur_path) {
        cur_path.add(v);

        List<Integer> r = new ArrayList<>();
        for (Integer need : graph[v].need){

            if(total[need] != null){
                r.addAll(total[need]);
                continue;
            }

            if(cur_path.contains(need)){
                return null;
            }

            List<Integer> t = check(need, graph, total, cur_path);
            if(t == null){
                return null;
            }
            r.addAll(t);
        }

        cur_path.remove(v);

        total[v] = r;
        total[v].add(v);

        return total[v];
    }

    public static class V{
        public V(int v){
            this.course = v;
        }

        public int course;
        public Set<Integer> need = new HashSet<>();
    }

    public static void main(String[] args) {
        new Solution().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        new Solution().findOrder(2, new int[][]{{1,0},{0, 1}});
    }
}