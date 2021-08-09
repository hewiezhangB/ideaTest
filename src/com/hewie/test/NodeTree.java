package com.hewie.test;

public class NodeTree {
    /**根节点数据*/
    int data;
    /**左子树*/
    NodeTree left;
    /**右子树*/
    NodeTree right;
    public NodeTree() {
        super();
    }
    public NodeTree(int data) { //实例化二叉树
        super();
        this.data = data;
        left=null;
        right=null;
    }

    public void insert(NodeTree root,int data){
        //如果插入的节点大于跟节点
        if(data>root.data){
            //如果右子树为空，就插入，如果不为空就再创建一个节点
            if(root.right==null){
                //就把插入的节点放在右边
                root.right=new NodeTree(data);
            }else{
                insert(root.right, data);
            }
            //如果插入的节点小于根节点
        } else {
            //如果左子树为空，就插入，如果不为空就再创建一个节点
            if(root.left == null){
                //就把插入的节点放在左边边
                root.left=new NodeTree(data);
            }else{
                insert(root.left, data);
            }
        }
    }
}
