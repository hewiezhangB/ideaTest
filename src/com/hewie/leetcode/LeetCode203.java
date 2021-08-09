package com.hewie.leetcode;

public class LeetCode203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head.next == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        if(head.val == val){
            return head.next;
        } else {
            return head;
        }
    }

}
