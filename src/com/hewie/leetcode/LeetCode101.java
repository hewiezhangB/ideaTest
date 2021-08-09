package com.hewie.leetcode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left,TreeNode right){
        if(left == null && right != null){
            return false;
        } else if(left != null && right == null){
            return false;
        } else if(left == null && right == null){
            return true;
        } else if (left.val != right.val){
            return false;
        }
        return compare(left.left,right.right) && compare(left.right,right.left);
    }
}
