package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode1423 {
    public int maxScore(int[] cardPoints, int k) {
        int m = cardPoints.length;
        int winSize = m - k;
        int count = 0;
        for (int i = 0; i < winSize; i++) {
            count += cardPoints[i];
        }
        int minCount = count;
        for (int i = winSize; i < m; ++i) {
            count += cardPoints[i] - cardPoints[i - winSize];
            minCount = Math.min(minCount, count);
        }
        return Arrays.stream(cardPoints).sum() - minCount;
    }
}
