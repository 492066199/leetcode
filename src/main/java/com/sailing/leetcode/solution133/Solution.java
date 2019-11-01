package com.sailing.leetcode.solution133;

import com.sailing.leetcode.other.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);

        //fix neighbors
        for (Node tmp : map.values()){
            List<Node> nn = new ArrayList<>(tmp.neighbors.size());
            for (Node n : tmp.neighbors){
                nn.add(map.get(n));
            }
            tmp.neighbors = nn;
        }
        return map.get(node);
    }

    private void dfs(final Node node, Map<Node, Node> map) {
        Node bak = map.get(node);
        if(bak != null){
            return;
        }else {
            bak = new Node();
            bak.val = node.val;
            bak.neighbors = node.neighbors;

            map.put(node, bak);

            for (Node next : bak.neighbors){
                dfs(next, map);
            }
        }
    }
}
