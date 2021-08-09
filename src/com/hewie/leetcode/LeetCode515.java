package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        int lineValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                lineValue = Math.max(lineValue,treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            result.add(lineValue);
            lineValue = Integer.MIN_VALUE;
        }
        return result;
    }
}
