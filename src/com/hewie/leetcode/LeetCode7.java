package com.hewie.leetcode;

public class LeetCode7 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int popular = x % 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && popular > 7)) {
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && popular < -8)) {
                return 0;
            }
            result = result * 10 + popular;
            x /= 10;
        }
        return result;
    }
}
