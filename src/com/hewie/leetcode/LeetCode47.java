package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        result.clear();
        path.clear();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backLoop(nums,used);
        return result;
    }

    private void backLoop(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            if(used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backLoop(nums,used);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,1,2};
        int[] array1 = {1,2,3};
        LeetCode47 leetCode47 = new LeetCode47();
        System.out.println(leetCode47.permuteUnique(array));
        System.out.println(leetCode47.permuteUnique(array1));
    }

}
