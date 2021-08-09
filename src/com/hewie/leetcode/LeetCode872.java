package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode872 {
    /**
     * Definition for a binary tree node.
     * */
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftList = new ArrayList<>();
        if(root1 != null){
            findTreeNode(root1,leftList);
        }
        List<Integer> rightList = new ArrayList<>();
        if(root2 != null){
            findTreeNode(root2,rightList);
        }
        return leftList.equals(rightList);
    }

    private void findTreeNode(TreeNode node, List<Integer> valList){
         if(node.left == null && node.right == null){
             valList.add(node.val);
         } else {
             if(node.left != null){
                 findTreeNode(node.left,valList);
             }
             if(node.right != null){
                 findTreeNode(node.right,valList);
             }
         }
    }
}
