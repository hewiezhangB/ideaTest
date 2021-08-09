package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<Integer> path = new LinkedList<>();
        dfsTree(root,targetSum,path,result);
        return result;
    }

    private void dfsTree(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> result){
        path.add(root.val);
        //找到叶子节点的和等于目标值
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if(root.left != null){
            dfsTree(root.left,targetSum - root.val,path,result);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            dfsTree(root.right,targetSum - root.val,path,result);
            path.remove(path.size() - 1);
        }
    }
}
