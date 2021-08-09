package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77_1 {
    List<List<Integer>> resultList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backLoop(n,k,1);
        return resultList;
    }

    private void backLoop(int n,int k,int startIndex){
        //终止条件
        if(path.size() == k){
            //放入结果集
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            //处理节点
            path.add(i);
            backLoop(n,k,i + 1);
            //回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode77_1 leetCode77_1 = new LeetCode77_1();
        System.out.println(leetCode77_1.combine(4,2));
    }
}
