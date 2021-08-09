package com.hewie.leet;

public class Leet203 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode myHead = new ListNode(-1,head);
        ListNode pre = myHead;
        ListNode curr = head;
        while (curr != null){
            if(curr.val == val){
                //移动指针
                pre.next = curr.next;
            } else{
                //移动节点
                pre = curr;
            }
            //节点向前移动一位
            curr = curr.next;
        }
        return myHead.next;
    }
}
