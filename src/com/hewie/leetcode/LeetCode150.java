package com.hewie.leetcode;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 逆波兰表达式
 * */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numQeque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if(isNumber(tokens[i])){
                numQeque.push(Integer.parseInt(tokens[i]));
            } else {
                int numTwo = numQeque.poll();
                int numOne = numQeque.poll();
                switch (tokens[i]){
                    case "+":
                        numQeque.push(numOne + numTwo);
                        break;
                    case "-":
                        numQeque.push(numOne - numTwo);
                        break;
                    case "*":
                        numQeque.push(numOne * numTwo);
                        break;
                    case "/":
                        numQeque.push(numOne / numTwo);
                        break;
                    default:
                }
            }
        }
        return numQeque.pop();
    }

    private boolean isNumber(String num){
        return !("+".equals(num) || "-".equals(num) || "*".equals(num) || "/".equals(num));
    }

    public static void main(String[] args) {
        String[] res = {"4","13","5","/","+"};
        System.out.println(new LeetCode150().evalRPN(res));
    }
}
