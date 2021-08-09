package com.hewie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        int result = 0;
        int temp;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int a: A) {
            for (int b:B) {
                temp =  a + b;
                if(sumMap.containsKey(temp)){
                    sumMap.put(temp,sumMap.get(temp) + 1);
                } else {
                    sumMap.put(temp,1);
                }
             }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int c:C) {
            for (int d:D) {
                temp =  c + d;
                if(sumMap.containsKey(0-temp)){
                    result += sumMap.get(0-temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2},B = {-2,-1},C = {-1, 2},D = {0, 2};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
