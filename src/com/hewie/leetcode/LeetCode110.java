package com.hewie.leetcode;
public class LeetCode110 {

    private boolean isBanceSele(TreeNode root){
        return getDepth(root) == -1 ? false:true;
    }

    private int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if(leftDepth == -1){
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1){
            return -1;
        }
        return Math.abs(leftDepth-rightDepth) > 1 ? -1:1 + Math.max(leftDepth,rightDepth);
    }

//    public boolean isBalanced(TreeNode root) {
//        return isBanceSele(root) != -1;
//    }
//
//    private int isBanceSele(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        int left = isBanceSele(root.left);
//        if(left == -1){
//            return -1;
//        }
//        int right = isBanceSele(root.right);
//        if(right == -1){
//            return -1;
//        }
//        return Math.abs(left - right) < 2 ? Math.max(left,right) +1:-1;
//    }
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
}
