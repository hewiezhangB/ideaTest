package com.hewie.leetcode;

public class LeetCode938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
//        int count = 0;
//        Stack<TreeNode> stack = new Stack();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if(node != null){
//                if(low < node.val && node.val <= high){
//                    count += node.val;
//                }
//                if(low < node.val){
//                    stack.push(node.left);
//                }
//                if(node.val < high){
//                    stack.push(node.right);
//                }
//            }
//        }
//        return count;
        if(root == null){
            return 0;
        }
        if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        if(root.val > high){
            return rangeSumBST(root.left,low,high);
        }
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



