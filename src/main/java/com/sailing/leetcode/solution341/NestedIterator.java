package com.sailing.leetcode.solution341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> data;
    private LinkedList<Node> stack = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.data = nestedList;

        if(data == null || data.size() == 0){

        }else {
            //init 0
            Node cur = new Node(data, 0);
            stack.addLast(cur);
            initstack(cur);
        }
    }

    private void initstack(Node cur) {

        while (stack.size() != 0){
            if(cur.offset >= cur.list.size()){
                stack.removeLast();
                if(stack.size() == 0){
                    return;
                }else {
                    cur = stack.getLast();
                    cur.offset ++;
                    continue;
                }
            }

            NestedInteger nested = cur.list.get(cur.offset);
            while (!nested.isInteger() && nested.getList().size() > 0){

                 stack.addLast(new Node(nested.getList(), 0));
                 cur = stack.getLast();

                 nested = nested.getList().get(0);
             }

             if(nested.isInteger()){
                 return;
             }else {
                cur.offset ++;
             }
        }
    }

    @Override
    public Integer next() {
        if(stack.size() == 0){
            throw new RuntimeException();
        }else {
            Node cur = stack.getLast();
            Integer r = cur.list.get(cur.offset).getInteger();
            //find next
            cur.offset ++;
            initstack(cur);

            return r;
        }
    }


    @Override
    public boolean hasNext() {
        if(stack.size() == 0){
            return false;
        }
        return true;
    }

    public static class Node{
        public List<NestedInteger> list;
        public int offset;

        public Node(List<NestedInteger> data, int i) {
            offset = i;
            list = data;
        }
    }




    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
