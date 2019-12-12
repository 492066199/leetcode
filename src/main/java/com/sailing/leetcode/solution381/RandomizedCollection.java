package com.sailing.leetcode.solution381;

import java.util.*;

/***
 *
 * @author sailing
 *
 *
 */
public class RandomizedCollection {
    private Map<Integer, List<Integer>> cache = new HashMap<>();
    private List<Integer> array = new ArrayList<>();
    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean r = false;
        List<Integer> ss = cache.get(val);
        if(ss == null){
            r = true;
            ss = new LinkedList<>();
            cache.put(val, ss);
        }

        array.add(val);
        ss.add(array.size() - 1);
        return r;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        List<Integer> ss = cache.get(val);
        if(ss == null){
            return false;
        }else {
            //self
            int max = -1;
            for (Integer index : ss){
                max = Math.max(index, max);
            }

            ss.remove((Object)max);
            if(ss.size() == 0){
                cache.remove(val);
            }

            if(max == array.size() - 1){
               array.remove(array.size() - 1);
                //swich one
            }else {
                //switch array
                int need = array.get(array.size() - 1);
                array.set(max, need);
                array.remove(array.size() - 1);

                ss = cache.get(need);
                ss.remove((Object)array.size());
                ss.add(max);
            }
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(array.size());
        return array.get(index);
    }


    public static void main(String[] args) {
        double rand = Math.random();
        System.out.println(rand);
    }
}
