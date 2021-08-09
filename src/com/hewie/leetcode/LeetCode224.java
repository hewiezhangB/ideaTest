package com.hewie.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode224 {
    public int calculate(String s) {
        Deque<Integer> option = new LinkedList<Integer>();
        option.push(1);
        int sign = 1;
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = option.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -option.peek();
                i++;
            } else if (s.charAt(i) == ')') {
                option.pop();
                i++;
            } else if (s.charAt(i) == '(') {
                option.push(sign);
                i++;
            } else {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}
