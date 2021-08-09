package com.hewie.leetcode;

public class LeetCode852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; ++i) {
            if(arr[i] > arr[i+1]){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(array));
    }
}
