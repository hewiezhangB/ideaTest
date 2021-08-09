package com.hewie.leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetOffer135 {
    public int search(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int count = (int) list.stream().filter(ele -> ele.equals(target)).count();
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        LeetOffer135 leetOffer135 = new LeetOffer135();
        System.out.println(leetOffer135.search(arr,8));
    }
}
