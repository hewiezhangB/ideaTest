package com.hewie.leetcode;

/**
 * head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * */
public class LeetCodeView18 {

    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            this.value = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.value == val){
            return head.next;
        }
        ListNode pre = head,curr= head.next;
        while (curr != null && curr.value != val){
            pre = curr;
            curr = curr.next;
        }
        if(curr != null){
            pre.next = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,9};
        LeetCodeView18 leeCView = new LeetCodeView18();
        ListNode listNode = new ListNode(5);
//        leeCView.deleteNode(array.to,5);
    }

    public ListNode deleteNode1(ListNode head, int val) {
        if(head.value == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.value != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
