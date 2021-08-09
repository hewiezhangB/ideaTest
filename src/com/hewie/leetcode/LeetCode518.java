package com.hewie.leetcode;

public class LeetCode518 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin:coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5};
        System.out.println(change(5,array));
    }
}
