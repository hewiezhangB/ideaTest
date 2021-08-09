package com.hewie.leetcode;

public class LeetcodeOffer15 {
    public static int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            result ++;
            n &= n -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
