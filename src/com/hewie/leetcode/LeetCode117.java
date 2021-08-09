package com.hewie.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i < size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
