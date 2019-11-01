package com.sailing.leetcode.solution225;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> stackList;
    LinkedList<Integer> queueList;

    /** Initialize your data structure here. */
    public MyStack() {
        stackList = new LinkedList();
        queueList = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(stackList.size() == 0){
            stackList.addFirst(x);
        }else {
            Integer t = stackList.removeLast();
            queueList.addFirst(t);
            stackList.addFirst(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer r = stackList.removeLast();

        while (queueList.size() > 1){
            int tmp = queueList.removeLast();
            stackList.addFirst(tmp);
        }

        //swap
        LinkedList<Integer> t = stackList;
        stackList = queueList;
        queueList = t;

        return r;
    }

    /** Get the top element. */
    public int top() {
        return stackList.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(stackList.isEmpty() && queueList.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
