package com.hewie.leet;
/**
 class Solution {
     public ListNode reverseBetween(ListNode head, int m, int n) {
         // 定义一个dummyHead, 方便处理
         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;

         // 初始化指针
         ListNode g = dummyHead;
         ListNode p = dummyHead.next;

         // 将指针移到相应的位置
         for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
         }

         //头插法插入节点
         for (int i = 0; i < n - m; i++) {
             ListNode removed = p.next;
             p.next = p.next.next;
             removed.next = g.next;
             g.next = removed;
         }
        return dummyHead.next;
     }
 }*/
public class Leet92 {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode custHeadNode = new ListNode(0);
        custHeadNode.next = head;

        //初始化指针
        ListNode leftNode = custHeadNode;
        ListNode rightNode = custHeadNode.next;

        //移动到相应位置上
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        //交换元素
        for (int i = 0; i < right - left; i++) {
            ListNode removed = rightNode.next;
            rightNode.next = rightNode.next.next;
            removed.next = leftNode.next;
            leftNode.next = removed;
        }
        return custHeadNode.next;
    }

    public static ListNode reverse(ListNode head) {
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
        ListNode result = reverseBetween(myListNode(),2,4);
        ListNode res = reverse(myListNode());
        for (ListNode curr = res;curr != null;curr = curr.next) {
            System.err.print(curr.val);
        }
        System.out.println(System.lineSeparator());
        for (ListNode curr = result;curr != null;curr = curr.next) {
            System.out.print(curr.val);
        }
    }


}
