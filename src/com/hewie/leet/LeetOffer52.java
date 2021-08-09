package com.hewie.leet;
/**
 * 链表相交:双指针法，有缘（有规律）即可寻，浪漫即相遇
 *
 * */
public class LeetOffer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lengthA = 0,lengthB = 0;
        //链表长度
        while (nodeA != null){
            lengthA ++;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            lengthB ++;
            nodeB = nodeB.next;
        }
        //回置链表
        nodeA = headA;
        nodeB = headB;
        if(lengthB > lengthA){
            //长度更换
            int tempLenB = lengthB;
            lengthB = lengthA;
            lengthA = tempLenB;
            //节点更换
            ListNode tempNode = nodeB;
            nodeB = nodeA;
            nodeA = tempNode;
        }
        //计算指针相差位置
        int gaps = lengthA - lengthB;
        //移动指针到同一位置
        while (gaps-- > 0){
            nodeA = nodeA.next;
        }
        //便利链表，遇到相同值则返回
        while (nodeA != null){
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
