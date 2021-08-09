package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        binaryTree(root,result);
        return result;
    }

    private void binaryTree(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        binaryTree(root.left,result);
        binaryTree(root.right,result);
    }
}
