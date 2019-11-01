package com.sailing.leetcode.solution56;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 1){
            return intervals;
        }
        List<Interval> result = new ArrayList<>(intervals.size());
        for(Interval interval : intervals){
            addToResut(interval, result);
        }
        return result;
    }

    private void addToResut(Interval interval, List<Interval> result) {
        List<Interval> needMerge = new ArrayList<>();
        Iterator<Interval> itor = result.iterator();
        while(itor.hasNext()){
            Interval cur = itor.next();
            if(cur.start > interval.end || cur.end < interval.start){
                continue;
            }
            needMerge.add(cur);
            itor.remove();
        }

        for(Interval cur : needMerge){
            if(cur.end > interval.end){
                interval.end = cur.end;
            }

            if(cur.start < interval.start){
                interval.start = cur.start;
            }
        }

        result.add(interval);
    }


    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
     
}
