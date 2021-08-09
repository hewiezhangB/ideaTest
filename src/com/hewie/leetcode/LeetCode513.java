package com.hewie.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if(i == 0){
                    result = treeNode.val;
                }
                if(treeNode.left != null){
                    queue.offer(root.left);
                }
                if(treeNode.right != null){
                    queue.offer(root.right);
                }
            }
        }
        return result;
    }
}
