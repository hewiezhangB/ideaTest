package com.hewie.leetcode;

/**
 * @author 反转二叉树
 * */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode treeNode){
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }
}
