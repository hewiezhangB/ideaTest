package com.hewie.leetcode;

public class LeetCode1486 {
    public static int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = start + 2*i;
            System.out.println(x);
            result ^= x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("\"___________________\""+xorOperation(4,3));
        System.out.println("\"___________________\""+xorOperation(5,0));
    }
}
