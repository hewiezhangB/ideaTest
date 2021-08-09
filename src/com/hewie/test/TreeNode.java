package com.hewie.test;

import java.util.List;

public class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;
    public List<Node> children;

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public TreeNode(int data, List<Node> children) {
        data = data;
        children = children;
    }

    public void insert(TreeNode root, int data){
        if(data > root.data) {
            if(root.rightNode == null){
                root.rightNode = new TreeNode(data);
            } else {
                insert(root.rightNode,data);
            }
        } else {
            if(root.leftNode == null){
                root.leftNode = new TreeNode(data);
            } else {
                insert(root.leftNode,data);
            }
        }
    }

}
