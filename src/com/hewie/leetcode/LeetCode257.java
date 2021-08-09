package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * */
public class LeetCode257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ways = new ArrayList<String>();
        findAllWays(root,"",ways);
        return ways;
    }

    private void findAllWays(TreeNode root,String way,List<String> ways) {
        StringBuilder pathWay = new StringBuilder(way);
        pathWay.append(Integer.valueOf(root.val));
        if(root.left == null && root.right == null){
            ways.add(pathWay.toString());
        } else {
            /**
             * 当前节点非叶子节点，继续遍
             */
            pathWay.append("->");
            findAllWays(root.left,pathWay.toString(),ways);
            findAllWays(root.right,pathWay.toString(),ways);
        }
    }
}
