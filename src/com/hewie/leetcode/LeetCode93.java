package com.hewie.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {
    List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backLoop(s,0,0);
        return result;
    }

    private void backLoop(String s,int startIndex,int pointNum){
        if(pointNum == 3){
            if(isVaild(s,startIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isVaild(s,startIndex,i)){
                s = s.substring(0,i + 1)+"."+s.substring(i + 1);
                pointNum ++;
                backLoop(s,i + 2,pointNum);
                pointNum --;
                s = s.substring(0,i+1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private boolean isVaild(String s,int start,int end){
        if(start > end){
            return false;
        }
        // 0开头的数字不合法
        if(s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) -'0');
            if(num > 255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        System.out.println(leetCode93.restoreIpAddresses("25525511135"));
    }
}
