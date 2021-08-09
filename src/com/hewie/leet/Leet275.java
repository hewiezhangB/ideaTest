package com.hewie.leet;

public class Leet275 {
    public static int hIndex(int[] citations) {
        int h = 0;
        int end = citations.length - 1;
        while (end >= 0 && citations[end] > h){
            h ++;
            end --;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3,5,6};
        System.out.println(hIndex(arr));
    }
}
