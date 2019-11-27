package com.sailing.leetcode.solution352;

import java.util.Map;
import java.util.Map.*;
import java.util.TreeMap;

/***
 *
 * @author sailingYang
 * @date 2019-11-27
 */
public class SummaryRanges {
    private TreeMap<Integer, Integer> spanTree;


    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.spanTree = new TreeMap<>();
    }

    public void addNum(int val) {
        //exist or not
        Integer v = spanTree.get(val);
        if(v != null){
            return;
        }

        //find the before
        Entry<Integer, Integer> beforeEntry = spanTree.lowerEntry(val);

        Integer needMergeKey = null;

        //val is the smallest key
        if(beforeEntry == null){
            spanTree.put(val, val);
            needMergeKey = val;
        }else {
            //merge in it
            if(val <= beforeEntry.getValue()){
                return;
            } else {
                //can merge with it
                if(beforeEntry.getValue() + 1  == val){
                     spanTree.put(beforeEntry.getKey(), val);
                     needMergeKey = beforeEntry.getKey();
                }else {
                 //can't merge
                    spanTree.put(val, val);
                    needMergeKey = val;
                }
            }
        }

        //find the after
        Integer needMergeValue = spanTree.get(needMergeKey);
        Entry<Integer, Integer> after = spanTree.higherEntry(needMergeKey);
        if(after == null){
            return;
        }
        if(needMergeValue >= after.getKey() - 1){
            spanTree.put(needMergeKey, after.getValue());
            spanTree.remove(after.getKey());
        }
    }

    public int[][] getIntervals() {
        int [][] r = new int[spanTree.size()][];
        int count = 0;
        for (Entry<Integer, Integer> entry: spanTree.entrySet()){
            r[count] = new int[]{entry.getKey(), entry.getValue()};
            count ++;
        }
        return r;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        //1, 3, 7, 2, 6
        summaryRanges.addNum(1);
        summaryRanges.getIntervals();
        summaryRanges.addNum(3);
        summaryRanges.getIntervals();
        summaryRanges.addNum(7);
        summaryRanges.getIntervals();
        summaryRanges.addNum(2);
        summaryRanges.getIntervals();
        summaryRanges.addNum(6);
        summaryRanges.getIntervals();
    }
}
