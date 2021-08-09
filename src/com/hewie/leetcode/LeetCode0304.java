package com.hewie.leetcode;

import java.util.Stack;

public class LeetCode0304 {
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
    /** Initialize your data structure here. */
//    public MyQueue() {
//        stackOne = new Stack<Integer>();
//        stackTwo = new Stack<Integer>();
//    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (stackTwo.size() != 0){
            stackOne.push(stackTwo.pop());
        }
        stackOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stackOne.size() != 0){
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (stackOne.size() != 0){
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackOne.isEmpty() && stackTwo.isEmpty()){
            return true;
        }
        return false;
    }
}
