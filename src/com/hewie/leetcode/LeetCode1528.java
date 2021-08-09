package com.hewie.leetcode;

public class LeetCode1528 {
    public String restoreString(String s, int[] indices) {
        char[] finalArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            finalArray[indices[i]] = s.charAt(i);
        }
        return new String(finalArray);
    }

    public static void main(String[] args) {

    }
}
