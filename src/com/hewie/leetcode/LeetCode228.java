package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> target = new ArrayList<>();
        if(nums.length == 0){
            return  target;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0, j = i + 1;j < nums.length; i++,j++) {
           if(nums[j] - 1 > nums[i]){
                sb.append(nums[i]);
                target.add(sb.toString());
                sb = new StringBuffer();
            }else{
                if (sb.length() == 0){
                    sb.append(nums[i]);
                    sb.append("->");
                }
            }
        }
        target.add(sb.append(nums[nums.length - 1]).toString());
        return target;
    }
}
