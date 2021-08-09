package com.hewie.leetcode;

public class LeetCode664 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] fx = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            fx[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    fx[i][j] = fx[i][j-1];
                } else {
                    int minNum = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minNum = Math.min(minNum,fx[i][k] + fx[k + 1][j]);
                    }
                    fx[i][j] = minNum;
                }
            }
        }
        return fx[0][n-1];
    }
}
