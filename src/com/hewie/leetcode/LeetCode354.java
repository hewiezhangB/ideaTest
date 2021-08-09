package com.hewie.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int[] f = new int[envelopes.length];
        Arrays.fill(f,1);
        int result = 1;
        for (int i = 1; i < envelopes.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if(envelopes[j][1] < envelopes[i][1]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
            result = Math.max(result,f[i]);
        }
        return result;
    }
}
