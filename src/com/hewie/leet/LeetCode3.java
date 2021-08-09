package com.hewie.leet;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int maxString = 0;
        Map<Character,Integer> value = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(value.containsKey(s.charAt(i))){
                left = Math.max(left,value.get(s.charAt(i)) + 1);
            }
            value.put(s.charAt(i),i);
            maxString = Math.max(maxString,i - left +1);
        }
        return maxString;
    }

    public static void main(String[] args) {
        String aa = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(aa));
    }
}
