package com.hewie.leetcode;

public class LeetCode8 {
    public static int myAtoi(String s) {
        //去空格
        char[] chars = s.toCharArray();
        int index = 0;
        int length = s.length();
        while (index < length && chars[index] == ' '){
            index ++;
        }
        //全部为空格
        if(index == length){
            return 0;
        }
        //符号位判断
        int flag = 1;
        if (chars[index] == '+'){
            index ++;
        } else if(chars[index] == '-'){
            index ++;
            flag = -1;
        }
        //oldValue -- 保存之前处理的值，用来后续判断是否溢出
        int oldValue = 0;
        int newValue = 0;
        while (index < length){
            char temp = chars[index];
            //第一个字符是否是数字
            if(temp < '0' || temp > '9'){
                break;
            }
            int num = temp - '0';
            oldValue = newValue;
            newValue = newValue * 10 + num;
            //判断是否溢出
            if(newValue / 10 != oldValue){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //后移动一位
            index ++;
        }
        return flag * newValue;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("4193 with words"));
    }
}
