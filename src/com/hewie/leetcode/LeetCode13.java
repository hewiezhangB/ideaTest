package com.hewie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    Map<Character,Integer> symValues = new HashMap<Character, Integer>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            int values =symValues.get(s.charAt(i));
            if(i < s.length() - 1 && values < symValues.get(s.charAt(i + 1))){
                result -= values;
            } else {
                result += values;
            }
        }
        return result;
    }
}
