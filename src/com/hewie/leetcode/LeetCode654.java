package com.hewie.leetcode;

public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxBinaryTree(nums,0,nums.length);
    }

    private TreeNode constructMaxBinaryTree(int[] nums,int leftIndex,int rightIndex){
        if(rightIndex - leftIndex < 1){
            return null;
        }
        if(rightIndex - leftIndex == 1){
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = constructMaxBinaryTree(nums,leftIndex,maxIndex);
        root.right = constructMaxBinaryTree(nums,maxIndex + 1,rightIndex);
        return root;
    }
}
