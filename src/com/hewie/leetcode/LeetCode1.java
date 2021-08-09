package com.hewie.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public static int[] test(int[] nums,int target){
        Map<Integer,Integer> val= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(val.containsKey(target-nums[i])){
                return new int[] {val.get(target - nums[i]),i};
            }
            val.put(nums[i],i);
        }
        throw new IllegalArgumentException("无两数字之和");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15},nums1 = {3,2,4},nums2 = {3,3};
        System.out.println(Arrays.toString(test(nums,9)));
        System.out.println(Arrays.toString(test(nums1,6)));
        System.out.println(Arrays.toString(test(nums2,6)));
    }
}
