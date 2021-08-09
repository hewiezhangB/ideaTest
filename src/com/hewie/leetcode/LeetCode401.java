package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                System.err.println(Integer.bitCount(i));
                System.err.println(Integer.bitCount(j));
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    result.add(i + ":" + (j < 10 ? "0":"") + j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        readBinaryWatch(1);
//        String[] arr = {"0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"};
//        System.out.println(readBinaryWatch(1));
//        System.out.println(readBinaryWatch(9));
    }
}
