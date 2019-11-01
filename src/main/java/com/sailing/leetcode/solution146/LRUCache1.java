package com.sailing.leetcode.solution146;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * yangyang 2018-03-12
 * o(lg n)
 * beat 10%
 */
public class LRUCache1 {
    private final Map<Integer, Node> cache = new HashMap<>();
    private final TreeMap<Long, Integer> limitMap = new TreeMap<>();
    private long auto = 0;
    private final int limit;
    private final int NO_VALUE = -1;

    public LRUCache1(int capacity) {
        this.limit = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (null == node) {
            return NO_VALUE;
        }

        limitMap.remove(node.ttl);

        node.ttl = ++auto;
        limitMap.put(node.ttl, key);

        return node.value;
    }

    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n != null) {
            limitMap.remove(n.ttl);
            n.ttl = ++auto;
            n.value = value;

            cache.put(key, n);
            limitMap.put(n.ttl, key);
        }else {
            if (cache.size() == limit) {
                Map.Entry<Long, Integer> entry = limitMap.firstEntry();
                limitMap.remove(entry.getKey());
                cache.remove(entry.getValue());
            }
            n = new Node();
            n.ttl = ++auto;
            n.value = value;

            cache.put(key, n);
            limitMap.put(n.ttl, key);
        }
    }

    static class Node {
        int value;
        long ttl;
    }
}
