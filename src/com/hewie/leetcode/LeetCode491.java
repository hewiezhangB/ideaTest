package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode491 {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backLoop(nums,0);
        return result;
    }

    private void backLoop(int[] nums,int startIndex){
        if(path.size() > 1){
            result.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < path.get(path.size() -1) || used[nums[i]+100] == 1){
                continue;
            }
            used[nums[i]+100] = 1;
            path.add(nums[i]);
            backLoop(nums,i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 6, 7, 7};
        LeetCode491 leetCode491 = new LeetCode491();
        System.out.println(leetCode491.findSubsequences(array));
    }
}
