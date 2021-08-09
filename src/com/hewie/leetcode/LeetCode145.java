package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        binaryTree(root,result);
        return result;
    }

    private void binaryTree(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        binaryTree(root.left,result);
        binaryTree(root.right,result);
        result.add(root.val);
    }
}
