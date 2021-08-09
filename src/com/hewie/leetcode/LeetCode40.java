package com.hewie.leetcode;

import java.util.*;

public class LeetCode40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList path = new LinkedList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        result.clear();
        path.clear();
        Arrays.sort(candidates);
        backLoop(candidates,target,0,used,0);
        return result;
    }

    private void backLoop(int[] candidates, int target,int sum,boolean[] used,int startIndex){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if(i > 0 && candidates[i] == candidates[i-1] && used[i - 1] == false){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backLoop(candidates,target,sum,used,i+1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }

    /*List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return lists;
    }

    public void backTracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            deque.push(arr[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backTracking(arr, target, i + 1, flag);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp;
        }
    }*/

    public static void main(String[] args) {
        int[] array = {10,1,2,7,6,1,5};
        LeetCode40 leetCode40 = new LeetCode40();
        System.out.println(leetCode40.combinationSum2(array,8));
    }
}
