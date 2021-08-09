package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //去重
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //去重
                if(j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }
                int left = j + 1,right = nums.length - 1;
                while(right > left){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target){
                        left ++;
                    } else if(sum > target){
                        right --;
                    } else {
                        sumList.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        while (right > left && nums[right] == nums[right-1]){
                            right --;
                        }
                        while (right > left && nums[left] == nums[left +1]){
                            left ++;
                        }
                        left ++;
                        right --;
                    }
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(arr,0));
    }
}
