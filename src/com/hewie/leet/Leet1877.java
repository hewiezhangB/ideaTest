package com.hewie.leet;

import java.util.Arrays;

public class Leet1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[n - 1];
        for (int i = 0,j = n - 1; i <= j; i++,j--) {
            result = Math.max(result,nums[i] + nums[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,3};
        System.out.println(new Leet1877().minPairSum(arr));
    }
}
