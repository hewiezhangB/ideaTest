package com.hewie.leet;

import java.util.Arrays;

public class Leet611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        for (int i = n - 1; i >= 2; --i) {
            int left = 0,right = i - 1;
            while (left < right){
                if(nums[left] + nums[right] > nums[i]){
                    result += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        System.out.println(new Leet611().triangleNumber(arr));
    }
}
