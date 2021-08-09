package com.hewie.leet;

import java.util.Arrays;

public class Leet1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(a,b) -> a[0] - b[0]);
        for (int[] rang:ranges) {
            int le = rang[0];
            int ri = rang[1];
            if(le <= left && left <= ri){
                left = ri + 1;
            }
        }
        return left > right;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6}};
        System.out.println(new Leet1893().isCovered(arr,2,5));
        int[][] arr1 = {{1,10},{10,20}};
        System.out.println(new Leet1893().isCovered(arr1,21,21));
    }

}
