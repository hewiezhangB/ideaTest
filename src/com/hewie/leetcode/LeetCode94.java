package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        binaryTree(root,result);
        return result;
    }

    private void binaryTree(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        binaryTree(root.left,result);
        result.add(root.val);
        binaryTree(root.right,result);
    }

    public static void main(String[] args) {
        LeetCode94 leetcode94 = new LeetCode94();
//        TreeNode treeNode = new TreeNode(1,2,3);
//        leetcode94.inorderTraversal();
    }
}
