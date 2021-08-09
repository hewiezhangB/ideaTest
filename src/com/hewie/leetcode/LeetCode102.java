package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while (treeQueue.size() > 0){
            int size = treeQueue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeQueue.remove();
                path.add(treeNode.val);
                if(treeNode.left != null){
                    treeQueue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    treeQueue.add(treeNode.right);
                }
            }
            result.add(path);
        }
        return result;
    }
}
