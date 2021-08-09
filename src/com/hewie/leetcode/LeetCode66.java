package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode66 {
    public static int[] plusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if(i == digits.length-1){
                digits[i] += 1;
            }
            if(digits[i] > 9){
                digits = new int[digits.length+1];
                digits[0]=1;
                return digits;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] array = {9};
        int[] array1 = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne(array1)));
    }
}
