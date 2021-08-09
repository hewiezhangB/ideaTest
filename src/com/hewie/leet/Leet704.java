package com.hewie.leet;

public class Leet704 {
//    public int search(int[] nums, int target) {
//        if(target < nums[0] || target > nums[nums.length - 1]){
//            return -1;
//        }
//        int left = 0,right = nums.length - 1;
//        while (left <= right){
//            int middle = left + ((right - left) >> 1);
//            if(nums[middle] == target){
//                return middle;
//            } else if(nums[middle] < target){
//                left = middle + 1;
//            } else if(nums[middle] > target){
//                right = middle - 1;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                return middle;
            } else if(nums[middle] > target){
                right = middle - 1;
            } else if(nums[middle] < target){
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leet704 leet704 = new Leet704();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(leet704.search(nums,9));
    }
}
