package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YanghuiTriangle {
    public static int getRowNum(int n,int m) {
        List<Integer> rowCount = new ArrayList<Integer>();
        rowCount.add(1);
        for (int i = 1; i <= n-1; ++i) {
            rowCount.add((int) ((long) rowCount.get(i - 1) * (n-1 - i + 1) / i));
        }
        return rowCount.get(m-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入n值:");
//        int n = scanner.nextInt();
//        System.out.println("请输入m值:");
//        int m = scanner.nextInt();
//        System.err.println(getRowNum(n,m));

//        System.err.println(getRowNum(7,5));

        String input = scanner.nextLine();
        String[] nums = input.split(" ");
        System.err.println(getRowNum(Integer.valueOf(nums[0]),Integer.valueOf(nums[1])));
    }
}
