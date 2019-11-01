package com.sailing.leetcode.solution146;

/**
 * 钻了大漏洞  哈哈
 * 2018-03-12
 * yangyang
 * beat 97.35%
 */
public class LRUCache {
    private final int size;
    private final Node[] cache;
    private final int NO_VALUE = -1;
    private final Node head = new Node();
    private final Node tail = new Node();
    private int cur = 0;

    public LRUCache(int capacity) {
        this.size = capacity;
        cache = new Node[200000];

        head.next = tail;
        tail.pre = head;

        tail.next = null;
        head.pre = null;
    }

    public int get(int key) {
        Node node = cache[key];
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
        Node node = cache[key];
        if(node != null){
            node.value = value;

            deleteNode(node);
            addToHead(node);
        }else {
            node = new Node();
            node.key = key;
            node.value = value;
            if(cur == size){
                cache[tail.pre.key] = null;
                deleteNode(tail.pre);
            }else {
                cur++;
            }

            cache[key] = node;
            addToHead(node);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
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
