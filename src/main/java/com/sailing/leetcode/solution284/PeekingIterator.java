package com.sailing.leetcode.solution284;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> interIterator;
    private Integer cc;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.interIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(cc == null) {
            if(interIterator.hasNext()) {
                cc = interIterator.next();
            }
        }
        return cc;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(cc == null){
            return interIterator.next();
        }else {
            Integer tmp = cc;
            cc = null;
            return tmp;
        }
    }

    @Override
    public boolean hasNext() {
        if(cc == null){
            return interIterator.hasNext();
        }else {
            return true;
        }
    }
}
