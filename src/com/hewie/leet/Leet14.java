package com.hewie.leet;

import java.util.Arrays;

public class Leet14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < first.length; i++) {
            if(i < last.length && first[i] == last[i]) {
                stringBuilder.append(last[i]);
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(new Leet14().longestCommonPrefix(str));
    }
}
