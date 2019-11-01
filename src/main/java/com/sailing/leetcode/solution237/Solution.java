package com.sailing.leetcode.solution237;

import com.sailing.leetcode.other.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
