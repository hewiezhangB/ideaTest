package com.hewie.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<Integer>();
        int n = 10;
        for (int i = A.length - 1; i >= 0 || K > 0; --i,K /= n) {
            if(i >= 0){
                K += A[i];
            }
            result.add(K % 10);
        }
        Collections.reverse(result);
        return result;
    }
}
