package com.hewie.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.removeIf(ele -> ele.equals(ele));
        int[] nums1 = {1,2,2,1},nums2 = {2,2},nums3 = {4,9,5},nums4 = {9,4,9,8,4};
        System.out.println(Arrays.toString(test(nums1,nums2)));
        System.out.println(Arrays.toString(test(nums3,nums4)));
    }

    public static int[] test(int[] nums1,int[] nums2) {
        Set<Integer> numsSet1 = new HashSet<>();
        Set<Integer> numsSet2 = new HashSet<>();
        for (int num1:nums1) {
            numsSet1.add(num1);
        }
        for (int num2 : nums2) {
            if(numsSet1.contains(num2)){
                numsSet2.add(num2);
            }
        }
        int[] nums = new int[numsSet2.size()];
        int index = 0;
        for (int num:numsSet2) {
            nums[index ++] = num;
        }
        return nums;
    }
}
