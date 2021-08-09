package com.hewie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1074 {
    public int numSubmatrixSumTarget(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int top = 1; top <= n; top++) {
            for (int bot = top; bot <= n; bot++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int r = 1; r <= m; r++) {
                    cur = sum[bot][r] - sum[top - 1][r];
                    if (cur == t) {
                        ans++;
                    }
                    if (map.containsKey(cur - t)) {
                        ans += map.get(cur - t);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}
