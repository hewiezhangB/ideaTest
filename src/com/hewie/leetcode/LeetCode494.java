package com.hewie.leetcode;

public class LeetCode494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        findAgain(nums,target,0,0);
        return count;
    }

    private void findAgain(int[] nums, int target,int index,int result){
        if(index == nums.length){
            if(result == target){
                count ++;
            }
        } else {
            findAgain(nums,target,index + 1,result + nums[index]);
            findAgain(nums,target,index + 1,result - nums[index]);
        }
    }
}
