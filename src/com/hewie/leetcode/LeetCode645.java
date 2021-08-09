package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode645 {
    public int[] findErrorNums(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if(curr == pre){
                errorNums[0] = pre;
            } else if(curr - pre > 1){
                errorNums[1] = pre + 1;
            }
            pre = curr;
        }
        if(nums[n-1] != n){
            errorNums[1] = n;
        }
        return errorNums;
    }
}
