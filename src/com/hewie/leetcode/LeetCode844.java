package com.hewie.leetcode;

public class LeetCode844 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public String build(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '#'){
                stringBuilder.append(str.charAt(i));
            } else {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }
}
