package com.hewie.leet;

public class Leet171 {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leet171().titleToNumber("A"));
        System.out.println(new Leet171().titleToNumber("ZY"));
        System.out.println(new Leet171().titleToNumber("FXSHRXW"));
    }
}
