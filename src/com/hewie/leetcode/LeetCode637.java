package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            int size = queue.size();
            //统计每层总和
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }
}
