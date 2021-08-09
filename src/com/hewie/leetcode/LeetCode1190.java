package com.hewie.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1190 {
    public static String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            if(num == '(') {
                stack.push(stringBuilder.toString());
                stringBuilder.setLength(0);
            }else if(num == ')'){
                stringBuilder.reverse();
                stringBuilder.insert(0,stack.pop());
            } else {
                stringBuilder.append(num);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(i(love)you)"));
    }
}
