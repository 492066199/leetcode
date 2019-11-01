package com.sailing.leetcode.solution310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if(n == 0){
            return leaf;
        }

        if(n == 1){
            leaf.add(0);
            return leaf;
        }

        //construct graph
        Set<Integer>[] graph = new Set[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet();
        }

        for (int[] p : edges){
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }

        for(int i = 0; i < graph.length; i++ ){
            if(graph[i].size() == 1){
                leaf.add(i);
            }
        }

        while (n > 2){
            n = n - leaf.size();
            //remove leaf
            List<Integer> newLeaf = new ArrayList<>();
            for (Integer i : leaf){
                for(Integer j : graph[i]){
                    graph[j].remove(i);
                    if(graph[j].size() == 1){
                        newLeaf.add(j);
                    }
                }
                graph[i].clear();
            }

            leaf = newLeaf;
        }

        return leaf;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findMinHeightTrees(6,  new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(new Solution1().findMinHeightTrees(4,  new int[][]{
                {1,0},{1,2},{1,3}}));
    }
}
