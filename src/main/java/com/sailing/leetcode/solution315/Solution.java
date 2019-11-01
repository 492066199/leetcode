package com.sailing.leetcode.solution315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null){
            return null;
        }

        if(nums.length == 0){
            return new ArrayList<>();
        }

        Node[] nodeList = new Node[nums.length];
        for(int i = 0; i < nums.length; i++){
            Node node = new Node();
            node.val = nums[i];
            node.index = i;
            nodeList[i] = node;
        }

        MergeSortAndCount(nodeList, 0, nums.length - 1);

        int [] resultArray = new int[nums.length];
        for(Node node : nodeList){
            resultArray[node.index] = node.count;
        }

        List<Integer> integerList = new ArrayList<>(nums.length);
        for(int resilt : resultArray){
            integerList.add(resilt);
        }
        return integerList;
    }

    private void MergeSortAndCount(Node[] nodeList, int start, int end) {
        if(start == end){
            return;
        }

        int mid = (start + end) / 2;
        MergeSortAndCount(nodeList, start, mid);
        MergeSortAndCount(nodeList, mid + 1, end);

        Node[] aux = new Node[end - start + 1];
        int curIndex = aux.length - 1;

        int p1 = mid;
        int p2 = end;

        while (p2 >= (mid + 1) && p1 >= start) {
            if (nodeList[p2].val >= nodeList[p1].val) {
                aux[curIndex] = nodeList[p2];
                curIndex--;
                p2--;
            } else {
                int count = (p2 - mid - 1) + 1;
                nodeList[p1].count = nodeList[p1].count + count;
                aux[curIndex] = nodeList[p1];
                curIndex--;
                p1--;
            }
        }

        while (p2 >= (mid + 1)){
            aux[curIndex] = nodeList[p2];
            p2 --;
            curIndex --;
        }

        while (p1 >= start){
            aux[curIndex] = nodeList[p1];
            p1 --;
            curIndex --;
        }

        //copy back to array
        int auxIndex = 0;
        for (int i = start; i <= end; i++, auxIndex++){
            nodeList[i] = aux[auxIndex];
        }

        return;
    }


    public static class Node{
        int val;
        int count;
        int index;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5,2,6,1}));
    }
}
