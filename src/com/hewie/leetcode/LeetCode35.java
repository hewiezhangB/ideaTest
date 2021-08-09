package com.hewie.leetcode;

public class LeetCode35 {
    public static int searchInsert1(int[] nums, int target) {
        Boolean inNum = false;
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                inNum = true;
                return i;
            }
        }
        if(!inNum){
            for (int i = 0; i < nums.length; i++) {
                if(target < nums[i]){
                    return i;
                }
                continue;
            }
        }
        return nums.length;
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        System.out.println(searchInsert(array,2));
    }
}
