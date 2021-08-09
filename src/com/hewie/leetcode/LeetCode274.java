package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode274 {
    public static int hIndex(int[] citations) {
        //0,1,3,5,6
        Arrays.sort(citations);
        //引用次数
        int start = 0;
        //遍历起始位置
        int end = citations.length - 1;
        //由大到小遍历，当
        while (end >= 0 && citations[end] > start){
            start ++;
            end --;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        System.out.println(hIndex(arr));
    }
}
