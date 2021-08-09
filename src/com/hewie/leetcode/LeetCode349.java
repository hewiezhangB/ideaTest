package com.hewie.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();
        for (int num1:nums1) {
            num1Set.add(num1);
        }
        for (int num2:nums2) {
            if(num1Set.contains(num2)){
                num2Set.add(num2);
            }
        }
        int[] sameNum = new int[num2Set.size()];
        int index = 0;
        for (int i:num2Set) {
            sameNum[index++] = i;
        }
        return sameNum;
    }
}
