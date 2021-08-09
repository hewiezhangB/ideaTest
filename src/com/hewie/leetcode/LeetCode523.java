package com.hewie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m < 2){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int remind = 0;
        for (int i = 0; i < m; i++) {
            remind = (remind + nums[i]) % k;
            if(map.containsKey(remind)){
                int preIndex = map.get(remind);
                if(i - preIndex >= 2){
                    return true;
                }
            } else {
                map.put(remind,i);
            }
        }
        return false;
    }
}
