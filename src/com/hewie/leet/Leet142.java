package com.hewie.leet;

public class Leet142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            //fast指针移动两步
            fast = fast.next.next;
            //有环
            while (fast == slow){
                ListNode indexFast = fast;
                ListNode indexHead = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (indexFast != indexHead){
                    indexFast = indexFast.next;
                    indexHead = indexHead.next;
                }
                return indexFast;
            }
        }
        return null;
    }
}
