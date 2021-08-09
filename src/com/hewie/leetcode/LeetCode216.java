package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        result.clear();
        path.clear();
        backLoop(k,n,0,1);
        return result;
    }

    private void backLoop(int k, int n,int sum,int startIndex){
        if(sum > n){
            return;
        }
        if(path.size() == k){
            if(sum == n) {
                result.add(new ArrayList<>(path));
            }
            //当sum和为特定值时终止
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            sum += i;
            if(i > 9){
                break;
            }
            path.add(i);
            backLoop(k,n,sum,i + 1);
            sum -= i;
            path.removeLast();
        }
    }
    /*List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        list.clear();
        backtracking(k, n, 9);
        return res;
    }

    private void backtracking(int k, int n, int maxNum) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 因为不能重复，并且单个数字最大值是maxNum，所以sum最大值为
        // （maxNum + (maxNum - 1) + ... + (maxNum - k + 1)） == k * maxNum - k*(k - 1) / 2
        if (maxNum == 0
                || n > k * maxNum - k * (k - 1) / 2
                || n < (1 + k) * k / 2) {
            return;
        }
        list.add(maxNum);
        backtracking(k - 1, n - maxNum, maxNum - 1);
        list.remove(list.size() - 1);
        backtracking(k, n, maxNum - 1);
    }*/

    public static void main(String[] args) {
        LeetCode216 leetCode216 = new LeetCode216();
        System.out.println(leetCode216.combinationSum3(3,9));
        System.out.println(leetCode216.combinationSum3(3,7));
        System.out.println(leetCode216.combinationSum3(9,45));
        System.out.println(leetCode216.combinationSum3(2,18));
    }
}
