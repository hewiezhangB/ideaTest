package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (queue.size() > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                if(i == size-1){
                    result.add(treeNode.val);
                }
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
        }
        return result;
    }
}
