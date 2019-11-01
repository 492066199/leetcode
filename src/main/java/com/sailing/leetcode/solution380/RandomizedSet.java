package com.sailing.leetcode.solution380;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> cache = new HashMap<>();
    private List<Integer> array = new ArrayList<>();
    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(cache.containsKey(val)){
            return false;
        }else {
            int index = array.size();
            array.add(val);
            cache.put(val, index);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(cache.containsKey(val)){
            int index = cache.get(val);
            if(index != array.size() - 1){
                array.set(index, array.get(array.size() - 1));
                cache.put(array.get(array.size() - 1), index);
            }
            array.remove(array.size() - 1);
            cache.remove(val);
            return true;
        }else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(array.size());
        return array.get(index);
    }
}
