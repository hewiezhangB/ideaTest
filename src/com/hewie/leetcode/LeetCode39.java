package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backLoop(candidates,target,0,0);
        return result;
    }

    private void backLoop(int[] candidates, int target,int sum,int startIndex){
        if(sum > target){
            return;
        }
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backLoop(candidates,target,sum,i);
            sum -= candidates[i];
            if(path.size() != 0){
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,6,7};
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(array,7));
    }
}
