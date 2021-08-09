package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] numsString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        mappingNum(digits,0,numsString);
        return result;
    }
    StringBuilder res = new StringBuilder();
    private void mappingNum(String digits,int start,String[] numsString){
        if(digits.length() == start){
            result.add(res.toString());
            return;
        }
        String strNum = numsString[digits.charAt(start) - '0'];
        for (int i = 0; i < strNum.length(); i++) {
            res.append(strNum.charAt(i));
            mappingNum(digits,start + 1,numsString);
            res.deleteCharAt(res.length()-1);
        }
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations(""));
    }
}
