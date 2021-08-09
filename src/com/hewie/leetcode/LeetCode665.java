package com.hewie.leetcode;

public class LeetCode665 {
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        int down = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]){
                down ++;
            }
            if(down > 1){
                return false;
            }
            if(i > 1 && i < nums.length - 1 && nums[i - 1] > nums[i + 1] && nums[i - 2] > nums[i]){
                return false;
            }
        }
        return true;
    }
}
