package com.hewie.leet;

import java.util.Arrays;

public class Leet1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0,result = 0,total = 0;
        for (int i = 1; i < nums.length; i++) {
            total += (nums[i] - nums[i-1]) * (i - left);
            while (total > k){
                total -= nums[i] - nums[left];
                left ++;
            }
            result = Math.max(result,i - left);
        }
        return result + 1;
    }
}
