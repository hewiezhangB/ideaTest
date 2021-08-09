package com.hewie.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }

}
