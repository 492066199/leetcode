package com.sailing.leetcode.solution146;

import java.util.HashMap;

/**
 * 2018-03-12
 * 双向链表必须用自己实现的，不可以用jdk内置的.
 * yangyang
 * beat 40%
 */
public class LRUCache2 {
    private final int size;
    private final HashMap<Integer, Node> cache;
    private final int NO_VALUE = -1;
    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache2(int capacity) {
        this.size = capacity;
        cache = new HashMap<>((int)(capacity * 1.5));

        head.next = tail;
        tail.pre = head;

        tail.next = null;
        head.pre = null;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return NO_VALUE;
        }
        deleteNode(node);
        addToHead(node);
        return node.value;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        if(node == head || node == tail){
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.value = value;

            deleteNode(node);
            addToHead(node);
        }else {
            node = new Node();
            node.key = key;
            node.value = value;
            if(cache.size() == size){
                cache.remove(tail.pre.key);
                deleteNode(tail.pre);
            }

            cache.put(key, node);
            addToHead(node);
        }

    }

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
    }

    static class Node {
        int key;
        int value;

        Node pre;
        Node next;
    }
}
