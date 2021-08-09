package com.hewie.leetcode;

import java.util.*;

public class LeetCode38 {
    List<String> result = new LinkedList<>();
    char[] str;
    public String[] permutation(String s) {
        str = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }
    private void dfs(int x){
        if(x == str.length - 1){
            result.add(String.valueOf(str));
            return;
        }
        HashSet<Character> charSet = new HashSet<>();
        for (int i = x; i < str.length; i++) {
            if(charSet.contains(str[i])){
                continue;
            }
            charSet.add(str[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i,x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i,x);
        }
    }

    private void swap(int m,int n){
        char temp = str[m];
        str[m] = str[n];
        str[n] = temp;
    }
    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(Arrays.toString(leetCode38.permutation("abc")));
    }
}
