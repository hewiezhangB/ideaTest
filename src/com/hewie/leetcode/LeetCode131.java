package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {
//    boolean[][] f;
//    List<List<String>> result = new ArrayList<List<String>>();
//    List<String> fin = new ArrayList<String>();
//    int n;
//    public List<List<String>> partition(String s) {
//        n = s.length();
//        f = new boolean[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(f[i], true);
//        }
//        for (int i = n - 1; i >= 0; --i) {
//            for (int j = i + 1; j < n; ++j) {
//                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
//            }
//        }
//        dfs(s, 0);
//        return result;
//    }
//    public void dfs(String s, int i) {
//        if (i == n) {
//            result.add(new ArrayList<String>(fin));
//            return;
//        }
//        for (int j = i; j < n; ++j) {
//            if (f[i][j]) {
//                fin.add(s.substring(i, j + 1));
//                dfs(s, j + 1);
//                fin.remove(fin.size() - 1);
//            }
//        }
//    }

    List<List<String>> reuslt = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        reuslt.clear();
        path.clear();
        backLoop(s,0);
        return reuslt;
    }

    private void backLoop(String s,int startIndex){
        if(startIndex >= s.length()){
            reuslt.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindString(s,startIndex,i)){
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            } else {
                continue;
            }
            backLoop(s,i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindString(String s,int startIndex,int end){
        for (int i = startIndex, j = end; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode131 leetCode131 = new LeetCode131();
        System.out.println(leetCode131.partition("aab"));
    }
}
