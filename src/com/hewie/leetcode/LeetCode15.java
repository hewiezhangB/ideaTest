package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return resultList;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                //去重
                continue;
            }
            int right = nums.length - 1,left = i + 1;
            while(right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left ++;
                } else if (sum > 0) {
                    right --;
                } else {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        //去重
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums1 = {};
        int[] nums2 = {0};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
    }
}
