package com.hewie.leetcode;
/**
 * 汉明距离
 * */
public class LeetCode477 {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 30; i++) {
            int m = 0;
            for (int value : nums) {
                m += (value >> i) & 1;
            }
            result += m * (nums.length - m);
        }
        return result;
    }
}
