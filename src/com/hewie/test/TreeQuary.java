package com.hewie.test;

public class TreeQuary {
    private static void preList(TreeNode root){
        if(root != null){
            System.out.print(root.data+"->");
            preList(root.leftNode);
            preList(root.rightNode);
        }
    }

    private static void midList(TreeNode root){
        if(root != null){
            midList(root.leftNode);
            System.err.print(root.data + "->");
            midList(root.rightNode);
        }
    }

    private static void postList(TreeNode root){
        if(root != null){
            postList(root.leftNode);
            postList(root.rightNode);
            System.out.print(root.data + "->");
        }
    }

    public static void main(String[] args) {
        int[] array = {35,17,39,9,28,65,56,87};
        TreeNode treeNode = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            treeNode.insert(treeNode,array[i]);
        }
        System.out.println("先序遍历：");
        preList(treeNode);
    }
}
