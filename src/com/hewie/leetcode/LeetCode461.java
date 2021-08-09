package com.hewie.leetcode;

public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
