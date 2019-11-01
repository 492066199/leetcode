package com.sailing.leetcode.solution155;

import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        Integer curMin = minStack.peekLast();
        if(curMin == null){
            minStack.add(x);
        }else {
            minStack.add(Math.min(x, curMin));
        }
    }

    public void pop() {
        if(stack.size() == 0){
            return;
        }
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
