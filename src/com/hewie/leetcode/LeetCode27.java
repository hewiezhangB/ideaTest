package com.hewie.leetcode;

public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
//        int fast =0;
//        int slow;
//        for (slow = 0; fast < nums.length; fast++) {
//            if(nums[fast] != val){
//                nums[slow] = nums[fast];
//                slow ++;
//            }
//        }
//        return slow;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums,3));
    }

}
