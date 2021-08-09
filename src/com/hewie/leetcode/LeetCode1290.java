package com.hewie.leetcode;

public class LeetCode1290 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null){
            result <<= 1;
            result |= head.val;
            head = head.next;
        }
        return result;
    }
}
