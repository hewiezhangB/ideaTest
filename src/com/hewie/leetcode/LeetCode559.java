package com.hewie.leetcode;

public class LeetCode559 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth,maxDepth(root.children.get(i)));
        }
        return depth + 1;
    }
}
