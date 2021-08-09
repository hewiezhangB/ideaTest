package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int pre = 0;
        for (int i = 0; i < A.length; i++) {
            pre = ((pre << 1) + A[i]) % 5;
            list.add(pre == 0);
        }
        return list;
    }
}
