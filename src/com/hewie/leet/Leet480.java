package com.hewie.leet;

import java.util.Arrays;

public class Leet480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        double[] midArr = new double[n - k + 1];
        int[] window = new int[k];
        int flag = 0;

        //while循环会超时---要用for
        for (right=0;right<n;right++) {
            //窗口大小为k
            if (right - left + 1 == k) {
                //window中只有当前窗口中的k个排好序的元素
                window = (int[])sortArray(nums, left, right, k).clone();
                midArr[flag++] = getMid(window);
                left++;
            }
        }
        return midArr;
    }

    /**
     *求窗口中的中位数
     */
    private double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //避免溢出
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {

            return window[len / 2];
        }
    }

    /**
     * 给nums中当前窗口中的元素排序--返回的数组中只有排好序的窗口中的元素
     * */
    private int[] sortArray(int[] nums, int left, int right, int k) {
        int[] partArray = new int[k];
        int j = 0;
        for (int i=left;i<=right;i++) {
            partArray[j++] = nums[i];
        }
        Arrays.sort(partArray);
        return partArray;
    }

    public static void main(String[] args) {
        Leet480 leet480 = new Leet480();
//        leet480.medianSlidingWindow();
    }
}
