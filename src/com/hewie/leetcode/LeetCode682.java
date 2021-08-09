package com.hewie.leetcode;

import java.util.Stack;

public class LeetCode682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String option : ops) {
            if(option.equals("+")){
                int top = stack.pop();
                int newTop = stack.peek() + top;
                stack.push(top);
                stack.push(newTop);
            } else if(option.equals("C")){
                stack.pop();
            } else if(option.equals("D")){
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.parseInt(option));
            }
        }
        int count = 0;
        for (int num:stack) {
            count += num;
        }
        return count;
    }
}
