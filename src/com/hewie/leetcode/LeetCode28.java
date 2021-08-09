package com.hewie.leetcode;

public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(),n = needle.length();
        char[] a = haystack.toCharArray(),b = needle.toCharArray();
        for (int i = 0; i <= m - n; i++) {
            int x = i,y = 0;
            while (y < n && a[x] == b[y]){
                x ++;
                y ++;
            }
            if(y == n){
                return i;
            }
        }
        return -1;
    }
}
