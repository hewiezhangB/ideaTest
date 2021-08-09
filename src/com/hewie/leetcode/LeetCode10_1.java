package com.hewie.leetcode;

public class LeetCode10_1 {
    public int fib(int n) {
        int m = 0, o = 1,sum;
        for (int i = 0; i < o; i++) {
            sum = (m + o) % 1000000007;
            m = o;
            o = sum;
        }
        return m;
    }
}
