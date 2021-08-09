package com.hewie.leetcode;

public class LeetCode63 {
    public int maxProfit(int[] prices) {
        int take = Integer.MAX_VALUE,income = 0;
        for (int price: prices) {
            take = Math.min(take,price);
            income = Math.max(income,price-take);
        }
        return income;
    }
}
