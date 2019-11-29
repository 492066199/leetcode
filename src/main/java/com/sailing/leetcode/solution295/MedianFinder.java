package com.sailing.leetcode.solution295;


import java.util.LinkedList;

/***
 *
 * @author sailingYang
 * @date 2019-11-29 22:05
 *
 *
 */
public class MedianFinder {
    /** initialize your data structure here. */
    private SortedList head;
    private SortedList tail;


    public MedianFinder() {
       head = new SortedList();
       tail = new SortedList();
    }

    public void addNum(int num) {
        if(head.size() == 0){
            head.add(num);
        }else {
            Integer last = head.getLast();
            if(last <= num){
                tail.add(num);
            }else {
                head.add(num);
            }
        }
        refix();
    }

    /***
     * head == end
     *
     *
     */
    private void refix() {
        if(head.size() == tail.size()){
            return;
        }

        if(head.size() == tail.size() + 1){
            return;
        }

        if(head.size() == tail.size() + 2){
            Integer last = head.removeLast();
            tail.addFirst(last);
        }

        if(head.size() == tail.size() - 1){
            Integer f = tail.removeFirst();

            head.addLast(f);
        }

    }

    public double findMedian() {
        if (head.size == tail.size + 1) {
            return head.getLast();
        } else {
            return ((double)(head.getLast() + tail.getFirst()) / 2);
        }
    }


    public static class SortedList{
        Node head = null;
        Node tail = null;
        int size = 0;

        public int size() {
            return size;
        }

        public void add(int num) {
            if(head == null){
                Node node = new Node(num);
                head = node;
                tail = node;
            }else {
                Node cur = new Node(num);
                Node p = head;
                while (p != null && num >= p.data){
                    p = p.next;
                }

                if(p == null){
                    tail.next = cur;
                    cur.pre = tail;

                    tail = cur;
                }else {
                    if(p.pre != null) {
                        p.pre.next = cur;
                        cur.pre = p.pre;
                        p.pre = cur;
                        cur.next = p;
                    }else {
                        cur.next = head;
                        head.pre = cur;
                        head = cur;
                    }


                }
            }
            size ++;
        }

        public Integer removeLast() {
            Integer data = tail.data;

            tail = tail.pre;
            if(tail != null){
                tail.next.pre = null;
                tail.next = null;
            }else {
                head = null;
            }
            size --;

            return data;
        }

        public void addFirst(Integer last) {
            add(last);
        }

        public Integer removeFirst() {
            Integer data = head.data;
            head = head.next;

            if(head != null){
                head.pre.next = null;
                head.pre = null;

            }else {
                tail = null;
            }

            size--;
            return data;
        }

        public void addLast(Integer f) {
            if(size == 0){
                add(f);
            }else {
                Node node = new Node(f);
                node.pre = tail;
                tail.next = node;
                tail = tail.next;
                size ++;
            }
        }

        public Integer getLast() {
            return tail.data;
        }

        public Integer getFirst() {
            return head.data;
        }
    }

    public static class Node{
        Integer data;
        Node pre;
        Node next;

        public Node(int num) {
            this.data = num;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());

    }
}
