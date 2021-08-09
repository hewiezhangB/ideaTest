package com.hewie.leet;

public class Leet0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        //求链表长度
        int lengthA = 0,lengthB = 0;
        while (currA != null){
            lengthA ++;
            currA = currA.next;
        }
        while (currB != null){
            lengthB ++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        //将A作为最长链
        while (lengthA < lengthB){
            int tempLen = lengthA;
            lengthA = lengthB;
            lengthB = tempLen;

            ListNode tempCurr = currA;
            currA = currB;
            currB = tempCurr;
        }

        int lengthGap = lengthA - lengthB;
        //两链表末尾对齐
        while (lengthGap-- > 0){
            currA = currA.next;
        }

        //遇到相等的则返回
        while (currA != null){
            if(currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}
