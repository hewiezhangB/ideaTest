package com.hewie.leet;
/**
 * 两数之和
 * */
public class Leet2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            l1 = new ListNode(0);
        }
        if (l2 == null){
            l2 = new ListNode(0);
        }
        int listVal = l1.val + l2.val;
        if(listVal >= 10){
            listVal = listVal % 10;
            if(l1.next != null){
                l1.next.val += 1;
            } else {
                l1.next = new ListNode(1);
            }
        }
        return new ListNode(listVal,addTwoNumbers(l1.next,l2.next));
    }

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(myListNode1(),myListNode2());
        for (ListNode curr = result;curr != null;curr = curr.next) {
            System.out.print(curr.val);
        }
//        int[] l1 = {2,4,3};
//        int[] l2 = {5,6,4};
//        System.out.println((l1,l2));
    }

    private static ListNode myListNode1(){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

    private static ListNode myListNode2(){
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

}
