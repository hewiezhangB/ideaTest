package com.hewie.leetcode;

public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int sum = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]){
                count ++;
            } else {
                count = 1;
            }
            sum = count > sum ? count : sum;
        }
        return sum;
    }
}
