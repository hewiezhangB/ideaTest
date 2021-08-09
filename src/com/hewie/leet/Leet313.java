package com.hewie.leet;

import java.util.TreeSet;

public class Leet313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> treeSet = new TreeSet<>();
        //第一个丑数为1
        treeSet.add(1L);
        for (int i = 1; i < n; i++) {
            Long min = treeSet.pollFirst();
            for (int num:primes) {
                treeSet.add(num * min);
            }
        }
        return Math.toIntExact(treeSet.pollFirst());
    }

    public static void main(String[] args) {
        int[] arr1 = {2,7,13,19};
        System.out.println(new Leet313().nthSuperUglyNumber(12,arr1));
    }
}
