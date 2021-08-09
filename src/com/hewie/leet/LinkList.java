package com.hewie.leet;

public class LinkList {
    private static ListNode reserve(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = null;
        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            //后移动一位
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    private static ListNode myListNode(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        return listNode1;
    }
    public static void main(String[] args) {
        ListNode result = reserve(myListNode());
        for (ListNode curr = result;curr != null;curr = curr.next) {
            System.out.print(curr.val);
        }
    }
}
