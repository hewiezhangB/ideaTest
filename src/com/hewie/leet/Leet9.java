package com.hewie.leet;

import java.util.Arrays;

public class Leet9 {
    public boolean isPalindrome(int x) {
        String xx = String.valueOf(x);
        char[] charArrayJust = new char[xx.length()];
        char[] charArrayBack = new char[xx.length()];
        char[] charArray = xx.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int num = charArray[i];
            charArrayJust[i] = charArray[i];
            charArrayBack[i] = charArray[charArray.length-i-1];
        }
        if(Arrays.equals(charArrayBack,charArrayJust)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leet9().isPalindrome(-121));
    }
}
