package com.sailing.leetcode.solution10;

import java.util.LinkedList;

/**
 * 2018-03-19 create NFA
 * 2018-03-20 use NFA
 * beat 8%
 * yangyang
 */
public class Solution {
    private final static int INF = -2;
    private final static int E = -1;

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        Node head = createNFA(p);
        return filter(s, head);
    }

    private boolean filter(String s, Node p) {
        LinkedList<Node> backtrackList = new LinkedList<>();
        int comsume = 0;
        boolean needBack = false;
        while (true) {
            if (p == null && comsume == s.length()) {
                return true;
            }

            if (!needBack && p != null) {
                if (p.loop != Integer.MIN_VALUE) {
                    backtrackList.add(p);
                    p = p.next;
                    continue;
                }

                if (comsume >= s.length()) {
                    return false;
                }

                if (p.path == s.charAt(comsume) || p.path == INF) {
                    Node next = p.next;
                    comsume = comsume + 1;
                    p = next;
                }else {
                    needBack = true;
                }
            } else {
                //do backtrack
                while (true)  {
                    p = backtrackList.peekLast();
                    if (p == null) {
                        return false;
                    }
                    comsume = p.start;
                    for (Node node : backtrackList) {
                        comsume = comsume + node.useCount;
                    }

                    if (s.charAt(comsume) == p.loop || p.loop == INF) {
                        comsume ++;
                        p.useCount++;
                        p = p.next;
                        break;
                    }else {
                        Node t = backtrackList.pollLast();
                        t.useCount = 0;
                    }
                }
                needBack = false;
            }
        }
    }


    private Node createNFA(String p) {
        Node head = new Node();
        Node cur = head;
        int oc = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            cur.start = oc;
            if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                cur.loop = c == '.' ? INF : c;
                cur.path = E;
                i = i + 1;
            } else {
                cur.path = c == '.' ? INF : c;
                oc++;
            }

            if (i < p.length() - 1) {
                Node next = new Node();
                cur.next = next;
                cur = next;
            }
        }
        return head;
    }


    static class Node {
        int path;
        Node next;

        int loop = Integer.MIN_VALUE;
        int useCount;
        int start;
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("abaab",
//                "a*ba*bb*"));

//        System.out.println(new Solution().isMatch("aabccbcbacabaab",
//                ".*c*a*b.*a*ba*bb*"));

        System.out.println(new Solution().isMatch("ab",
                ".*c"));
    }
}
