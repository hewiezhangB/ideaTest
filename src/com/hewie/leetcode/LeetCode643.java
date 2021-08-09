package com.hewie.leetcode;

public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }
        int maxNum = count;
        for (int i = k; i < nums.length; i++) {
            count = count - nums[i - k] + nums[i];
            maxNum = Math.max(maxNum, count);
        }
        return 1.0 * maxNum / k;
    }
}
