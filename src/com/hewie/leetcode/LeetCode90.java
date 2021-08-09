package com.hewie.leetcode;

import java.util.*;

public class LeetCode90 {
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        Set<List<Integer>> answer = new HashSet<>();;
//        List<Integer> curr = new ArrayList<>();
//        isSonArray(nums,0,answer,curr);
//        return new ArrayList<>(answer);
//    }
//
//    /**
//     * @param nums 原输入数组
//     * @param now 当前决策到原输入数组中的哪一位
//     * @param curr 当前方案
//     * @param answer 最终结果集
//     */
//    private void isSonArray(int[] nums,int now,Set<List<Integer>> answer,List<Integer> curr){
//        // 所有位置都决策完成，将当前方案放入结果集
//        if(nums.length == now){
//            answer.add(new ArrayList<>(curr));
//            return;
//        }
//        // 选择当前位置的元素，往下决策
//        curr.add(nums[now]);
//        isSonArray(nums,now + 1,answer,curr);
//
//        // 不选当前位置的元素（回溯），往下决策
//        curr.remove(curr.size() - 1);
//        isSonArray(nums,now + 1,answer,curr);
//    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backLoop(nums,0);
        return result;
    }

    private void backLoop(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backLoop(nums,i + 1);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,2};
        int[] arr = {0};
        LeetCode90 leetCode90 = new LeetCode90();
        System.out.println(leetCode90.subsetsWithDup(array));
        System.out.println(leetCode90.subsetsWithDup(arr));
    }
}
