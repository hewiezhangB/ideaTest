package com.hewie.leetcode;

import java.util.*;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<Character,Character>(){
            {
                put('}','{');
                put(']','[');
                put('}','{');
            }
        };
        for (Character ch:s.toCharArray()) {
            if(!stack.isEmpty() && map.containsKey(ch)){
                if((stack.peek()).equals(map.get(ch))){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
//        Deque<Character> deque = new LinkedList<>();
//        for (char ch:s.toCharArray()) {
//            if(ch == '('){
//                deque.push(')');
//            } else if(ch == '['){
//                deque.push(']');
//            } else if(ch == '{'){
//                deque.push('}');
//            } else if (deque.isEmpty() || deque.peek() != ch){
//                return false;
//            } else {
//                deque.poll();
//            }
//        }
//        return deque.isEmpty();
    }
}
