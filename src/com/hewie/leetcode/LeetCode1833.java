package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode1833 {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int count = 0;
        for (int cost:costs) {
            result ++;
            count += cost;
            if(count > coins){
                result --;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,4,1};
        System.out.println(maxIceCream(array,7));
        int[] array1 = {10,6,8,7,7,8};
        System.out.println(maxIceCream(array1,5));
        int[] array2 = {1,6,3,1,2,5};
        System.out.println(maxIceCream(array2,20));
        int[] array3 = {7,3,3,6,6,6,10,5,9,2};
        System.out.println(maxIceCream(array3,56));
    }
}
