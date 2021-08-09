package com.hewie.leetcode;

public class LeetCode1094 {
    public int lastStoneWeightII(int[] stones) {
        int sumCount = 0;
        for (int stone : stones) {
            sumCount += stone;
        }
        int m = sumCount / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight:stones) {
            for (int i = m; i >= weight; --i) {
                dp[i] = dp[i] || dp[i - weight];
            }
        }
        for (int j = m;; --j) {
            if(dp[j]){
                return sumCount - 2 * j;
            }
        }
    }
}
