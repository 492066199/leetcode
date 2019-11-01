package com.sailing.leetcode.solution310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    int minHop = Integer.MAX_VALUE;
    List<Integer> rs = new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //construct graph
        Set[] graph = new Set[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet();
        }
        for (int[] p : edges){
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }

        //choose j as the root
        for(int j = 0; j < n; j++){
            dfs(graph, j);
        }

        return rs;
    }

    private void dfs(Set<Integer>[] graph, int root) {
        boolean[] total = new boolean[graph.length];
        List<Integer> cur = new ArrayList<>();
        List<Integer> next = new ArrayList<>();

        cur.add(root);
        total[root] = true;
        int hop = 0;

        while (cur != null && cur.size() != 0){
            hop++;
            if(hop > minHop){
                return;
            }
            for (Integer i : cur){
                for(Integer j : graph[i]){
                    if(total[j]){
                        continue;
                    }
                    next.add(j);
                    total[j] = true;
                }
            }
            cur.clear();
            List<Integer> tmp = cur;
            cur = next;
            next = tmp;
        }

        if(hop < minHop){
            minHop = hop;
            rs.clear();
            rs.add(root);
        }else if(hop == minHop){
            rs.add(root);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(6,  new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(new Solution().findMinHeightTrees(4,  new int[][]{
        {1,0},{1,2},{1,3}}));
    }
}
