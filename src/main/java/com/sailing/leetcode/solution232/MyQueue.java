package com.sailing.leetcode.solution232;

import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> inStack = new LinkedList<>();
    private LinkedList<Integer> outStack = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.size() > 0){
            return outStack.pop();
        }{
            transferFromInToOut();
            return outStack.pop();
        }
    }

    private void transferFromInToOut() {
        if(inStack.size() == 0){
            return;
        }else {
            int count = inStack.size();
            while (count > 0) {
                Integer c = inStack.pop();
                outStack.push(c);
                count --;
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.size() > 0){
            return outStack.getFirst();
        }else {
            transferFromInToOut();
            return outStack.getFirst();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        int total = inStack.size() + outStack.size();
        return total == 0 ? true : false;
    }
}
