package com.sailing.leetcode.solution23;


/**
 * beat 89.3%
 * yangyang
 * 2017-03-17
 * 满满的成就感
 */
public class Solution {
    ListNode[] root;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        root = lists;
        bulidheap();
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (root[0] != null){
            cur.next = root[0];
            cur = cur.next;
            root[0] = root[0].next;
            maxHeap(0);
        }
        return head.next;
    }

    public void bulidheap(){
        int last = (root.length - 1)/2;
        for(int i = last; i >= 0;i--){
            maxHeap(i);
        }
    }

    private void maxHeap(int i) {
        int min = i;
        int left = left(i);

        if(left < root.length && root[left] != null) {
            if (root[min] == null) {
                min = left;
            } else {
                if (root[left].val < root[min].val) {
                    min = left;
                }
            }
        }

        int right = right(i);
        if(right < root.length && root[right] != null) {
            if (root[min] == null) {
                min = right;
            } else {
                if (root[right].val < root[min].val) {
                    min = right;
                }
            }
        }

        if(min != i){
            ListNode tmp = root[i];
            root[i] = root[min];
            root[min] = tmp;
            maxHeap(min);
        }
    }

    public int left(int index){
        int l = (2 * index) + 1;
        return l;
    }

    public int right(int index){
        int r = (2 * index) + 2;
        return r;
    }

    public static void main(String[] args) {
        ListNode[] arg = new ListNode[3];
        arg[0] = new ListNode(2);
        arg[1] = null;
        arg[2] = new ListNode(-1);
        System.out.println(new Solution().mergeKLists(arg));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return " " + val +" ";
        }
    }
}
