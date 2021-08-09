package com.hewie.leetcode;

public class LeetCode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int result = 0;
        for (int[] demino : dominoes) {
            int value = demino[0] < demino[1] ? demino[0] * 10 + demino[1]:demino[1] * 10 +demino[0];
            result += num[value];
            num[value]++;
        }
        return result;
    }
}
