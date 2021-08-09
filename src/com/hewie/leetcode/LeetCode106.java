package com.hewie.leetcode;

import java.util.HashMap;

public class LeetCode106 {
    HashMap<Integer,Integer> nodeMap = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            nodeMap.put(inorder[i],i);
        }
        post = postorder;
        TreeNode root = buildTree(0,inorder.length - 1,0,post.length - 1);
        return root;
    }

    private TreeNode buildTree(int is, int ie, int ps, int pe){
        if(ie < is || pe < ps){
            return null;
        }
        int root = post[pe];
        int ri = nodeMap.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(is,ri - 1,ps,ps + ri - is - 1);
        node.right = buildTree(ri + 1,ie,ps + ri - is,pe - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] endOrder = {9,15,7,20,3};
        System.out.println(new LeetCode106().buildTree(inOrder,endOrder));
    }
}
