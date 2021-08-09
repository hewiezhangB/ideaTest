package com.hewie.leetcode;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode206 leetCode206 = new LeetCode206();
    }
}
