package com.hewie.leetcode;

public class Leetcode24 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode next = null;
//        ListNode pre = null;
//        while (head != null){
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;


//        newNext = reverseList(head.next.next);

//    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newNext = swapPairs(next.next);

        next.next = head;
        head.next = newNext;

        return next;
    }

    public static void main(String[] args) {
//        [1,2,3,4]
    }
}
