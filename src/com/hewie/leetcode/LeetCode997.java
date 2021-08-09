package com.hewie.leetcode;

public class LeetCode997 {
    public int findJudge(int N, int[][] trust) {
        int[] degree = new int[N + 1];
        for (int[] realtion:trust) {
            degree[realtion[1]]++;
            degree[realtion[0]]--;
        }
        int judge = -1;
        for (int i = 1; i <= N;i ++){
            if(degree[i] == N -1){
                judge = i;
                break;
            }
        }
        return judge;
    }
}
