package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        backLoop(nums,0);
        return result;
    }

    private void backLoop(int[] nums,int startIdex){
        result.add(new ArrayList<>(path));
        if(startIdex >= nums.length){
            return;
        }
        for (int i = startIdex; i < nums.length; i++) {
            path.add(nums[i]);
            backLoop(nums,i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] array = {0};
        LeetCode78 leetCode78 = new LeetCode78();
        System.out.println(leetCode78.subsets(arr));
        System.out.println(leetCode78.subsets(array));
    }

}
