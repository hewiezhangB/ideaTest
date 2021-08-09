package com.hewie.leetcode;

import java.util.*;

public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        queue.add(root);
        while (queue.size() > 0){
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                path.add(treeNode.val);
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            result.add(path);
        }
        Collections.reverse(result);
        return result;
    }
}
