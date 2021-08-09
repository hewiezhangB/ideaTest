package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return result;
        }
        used = new boolean[nums.length];
        backLoop(nums);
        return result;
    }

    private void backLoop(int[] nums){
        if(nums.length == path.size()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backLoop(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {0,1};
        int[] array3 = {1};
        LeetCode46 leetCode46 = new LeetCode46();
        System.out.println(leetCode46.permute(array1));
        System.out.println(leetCode46.permute(array2));
        System.out.println(leetCode46.permute(array3));
    }
}
