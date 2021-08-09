package com.hewie.leetcode;

public class LeetCode168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0){
            columnNumber --;
            System.err.println("------------"+columnNumber % 26);
            System.err.println(columnNumber % 26+'A');
            stringBuilder.append((char) (columnNumber % 26+'A'));
            System.err.println((char) (columnNumber % 26+'A'));
            columnNumber /= 26;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(29));
    }
}
