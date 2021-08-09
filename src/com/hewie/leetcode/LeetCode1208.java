package com.hewie.leetcode;

public class LeetCode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        s = " " + s;
        t = " " + t;
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Math.abs(sCh[i] - tCh[i]);
        }
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(sum, mid, maxCost)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return check(sum, r, maxCost) ? r : 0;
    }

        boolean check(int[] nums, int mid, int max) {
            for (int i = mid; i < nums.length; i++) {
                int tot = nums[i] - nums[i - mid];
                if (tot <= max) {
                    return true;
                }
            }
            return false;
        }

}
