package com.hewie.leetcode;

public class LeetCode947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSetUnion dsu = new DisjointSetUnion();
        for (int i = 0; i < n; i++) {
            dsu.unionSet(stones[i][0], stones[i][1] + 10000);
        }

        return n - dsu.numberOfConnectedComponent();
    }
}
