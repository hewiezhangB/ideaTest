package com.hewie.test;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1=new Node(1,"张三","小张");
        Node node2=new Node(3,"李四","小李");
        Node node3=new Node(4,"王五","小王");
        Node node4=new Node(2,"赵六","小赵");

        SingleLinkedList list=new SingleLinkedList();
        list.addByOrder(node1);
        list.addByOrder(node2);
        list.addByOrder(node3);
        list.addByOrder(node4);

        System.out.println("反转前:");
        list.showList();
        System.out.println("逆序输出(没有改变链表结构):");
        list.reserveShow(list.getHead());
        list.reserveLinkedList(list.getHead());
        System.out.println("反转后(改变链表结构):");
        list.showList();
        System.out.println("查找倒数第二个节点");
        Node n=list.getIndexNode(list.getHead(), 2);
        System.out.println("倒数第二个节点:"+n.toString());
    }
}

//定义Node, 每一个Node就是一个节点
class Node{

    public int num;
    public String name;
    public String nickName;
    public Node next;  //下一节点

    public Node(int num,String name,String nickName) {
        this.num=num;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "num:"+this.num+" name:"+this.name+" nickName:"+this.nickName;
    }

}

//定义单链表
class SingleLinkedList{

    //初始化头节点
    private Node head=new Node(0,"","");

    //获取头结点
    public Node getHead() {
        return head;
    }

    //添加节点
    //找到最后的节点，在其后方添加新节点
    public void addNode(Node Node) {

        //head节点不能动，用temp辅助操作
        Node temp=head;

        //遍历列表
        while(true) {
            //找到退出
            if(temp.next==null) {
                break;
            }
            temp=temp.next;
        }

        temp.next=Node;
    }

    //按顺序添加
    public void addByOrder(Node Node) {
        //寻找的节点是要添加位置的前一个
        Node temp=head;
        boolean flag=false;  //添加的节点是否存在

        while(true) {
            //temp为最后一个
            if(temp.next==null) {
                break;
            }

            if(temp.next.num>Node.num) {  //位置找到
                break;
            }else if(temp.next.num==Node.num) {   //节点已存在
                flag=true;
                break;
            }

            temp=temp.next;
        }

        if(flag) {
            System.out.println(Node+"节点已存在");
        }else {
            Node.next=temp.next;
            temp.next=Node;
            System.out.println(Node+"节点添加成功");
        }
    }

    //修改节点
    public void updateNode(Node Node) {
        if(head.next==null) {
            System.out.println("链表为空");
            return;
        }

        Node temp=head.next;
        boolean flag=false;

        while(true) {
            if(temp==null) {  //已经遍历完
                break;
            }

            if(temp.num==Node.num) {  //找到数据
                flag=true;
                break;
            }

            temp=temp.next;
        }

        if(flag) {
            temp.name=Node.name;
            temp.nickName=Node.nickName;
            System.out.println(Node+"修改成功");
        }else {
            System.out.println("未找到节点");
        }
    }

    //获取链表有效数据长度 hewie
    public int getLength(Node head) {
        //空链表
        if(head.next==null) {
            return 0;
        }

        int length=0;
        Node temp=head.next;

        while(temp!=null) {
            length++;
            temp=temp.next;
        }

        return length;
    }

    //删除节点
    public void deleteNode(int num) {
        Node temp=head;

        boolean flag=false;

        while(true) {
            if(temp.next==null) {  //已经遍历完
                break;
            }
            if(temp.next.num==num) {  //找到数据
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if(flag) {
            //变换节点
            //要删除的节点（没有指向）会被jvm回收
            temp.next=temp.next.next;
            System.out.println("节点删除成功");
        }else {
            System.out.println("未找到节点");
        }

    }

    //查找倒数第k个节点
    //先遍历链表，求取链表长度，遍历size-k次
    public Node getIndexNode (Node head,int index) {
        if(head.next==null) {
            return null; //链表为空
        }

        int size=getLength(head);  //链表长度

        if(size<=0||index>size) {
            return null;
        }

        Node temp=head.next;  //第一个数据
        for(int i=0;i<size-index;i++) {
            temp=temp.next;
        }
        return temp;
    }

    //反转链表
    //遍历链表，把链表的节点前插
    public void reserveLinkedList(Node head) {
        //链表为空,或链表只有一个值
        if(head.next==null||head.next.next==null) {
            return;
        }

        Node temp=head.next;
        Node next=null;  //当前节点的下一节点
        Node reserveHead=new Node(0,"","");   //反转列表的头结点

        while(temp!=null) {
            next=temp.next;  //先存储链表的  下一节点

            //前插
            temp.next=reserveHead.next;
            reserveHead.next=temp;

            //移到下一节点
            temp=next;

        }
        //实现列表反转
        head.next=reserveHead.next;
    }

    //显示列表
    public void showList() {
        if(head.next==null) {
            System.out.println("链表为空");
            return;
        }

        Node temp=head;
        //遍历列表
        while(true) {
            //找到退出
            if(temp.next==null) {
                break;
            }
            temp=temp.next;
            System.out.println(temp.toString());
        }
    }

    //逆序输出，通过栈的先进后出特性
    public void reserveShow(Node head) {
        if(head.next==null) {
            return;
        }

        Stack<Node> stack=new Stack<Node>();
        Node temp=head.next;

        while(temp!=null) {
            stack.push(temp);
            temp=temp.next;
        }

        while(stack.size()>0) {
            System.out.println(stack.pop());
        }
    }
}
