package com.hewie.leetcode;

public class LeetCode42 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1],0);
            result = Math.max(result,nums[i]);
        }
        return result;
    }
}
