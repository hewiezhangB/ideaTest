package com.hewie.leet;

import java.util.HashMap;
import java.util.Map;

public class Leet930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int result = 0;
        Map<Integer,Integer> recoadMap = new HashMap<Integer,Integer>(16);
        for (int num : nums) {
            recoadMap.put(sum,recoadMap.getOrDefault(sum,0) + 1);
            sum += num;
            result += recoadMap.getOrDefault(sum-goal,0);
        }
        return result;
    }
}
