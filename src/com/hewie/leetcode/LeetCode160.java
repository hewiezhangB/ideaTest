package com.hewie.leetcode;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA,pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : headA.next;
            pB = pB == null ? headA :headB.next;
        }
        return pA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
