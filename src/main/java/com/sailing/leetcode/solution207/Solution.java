package com.sailing.leetcode.solution207;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        Set<Integer> total = new HashSet<>();
        Set<Integer> cur_path = new HashSet<>();
        for(int v = 0; v < graph.length; v++) {
            if(!total.contains(v)) {
                if (!check(v, graph, total, cur_path)) {
                    return false;
                }
            }
        }


        return true;
    }

    private boolean check(int v, V[] graph, Set<Integer> total, Set<Integer> cur_path) {
        cur_path.add(v);

        for (Integer need : graph[v].need){
            if(total.contains(need)){
                continue;
            }

            if(cur_path.contains(need)){
                return false;
            }

            if(!check(need, graph, total, cur_path)){
                return false;
            }
        }

        cur_path.remove(v);

        total.add(v);
        return true;
    }

    public static class V{
        public V(int v){
            this.course = v;
        }

        public int course;
        public Set<Integer> need = new HashSet<>();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{0, 1}}));
    }

}
