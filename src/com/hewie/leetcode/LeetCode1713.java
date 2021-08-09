package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode1713 {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i], i);
        }
        ArrayList<Integer> stack = new ArrayList<>();
        for(int num:arr){
            Integer idx = map.get(num);
            if(idx != null){
                int l=0,r=stack.size();
                while(l<r){
                    int mid = l + r >> 1;
                    if(stack.get(mid) >= idx) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                if(l == stack.size()){
                    stack.add(idx);
                } else {
                    stack.set(l, idx);
                }
            }
        }
        return target.length - stack.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {5,1,3};
        int[] arr2 = {9,4,2,3,4};
        System.out.println(new LeetCode1713().minOperations(arr1,arr2));
    }
}
