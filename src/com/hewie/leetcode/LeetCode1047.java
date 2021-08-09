package com.hewie.leetcode;

import java.util.Stack;

public class LeetCode1047 {
    public String removeDuplicates(String S) {
        /** 只需删除重复项即可，因此可以使用栈实现
         * 每次添加时比较是否与栈顶元素相同
         *   - 若相同则删除栈顶元素且不插入
         *   - 若不相同则插入新元素
         * 时间复杂度：O(N)
         * 空间复杂度：O(N)
         */
        char[] s = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if(stack.isEmpty() || s[i] != stack.peek()){
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character charc: stack) {
            stringBuilder.append(charc);
        }
        return stringBuilder.toString();
    }
}
