package com.hewie.leetcode;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return getTreeDepth(root);
    }

    private int getTreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        int depth = 1 + Math.max(leftDepth,rightDepth);
        return depth;
    }
}
