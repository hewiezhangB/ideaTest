package com.hewie.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hewie
 * @date 2021-05-26 17:39:06
 * 杨辉三角
 *
 * 1. 每个数等于它上方两数之和。
 * 2. 每行数字左右对称，由1开始逐渐变大。
 * 第 n 行的数字有 n 项。
 *
 * 请编写一个程序，按题目要求输出杨辉三角中第 n 行第 m 个数字。
 *
 * 输入
 *
 * 第一行，两个数字 n 和 m ，表示需要输出的数字在杨辉三角上的位置，行列均从 1 开始，（1<=n,m<=10000），以空格分隔。
 *
 * 输出
 *
 * 仅包含一个整数，即杨辉三角中第 n 行第 m 列处的数字。
 *
 * 输入示例
 *
 * 7 5
 *
 * 输出示例
 *
 * 15
 * */

public class LeetCode118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(10);
        for (int i = 0; i < numRows; ++i) {
            List<Integer> num = new ArrayList<>(10);
//            System.out.format("%" + (numRows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j){
                    num.add(1);
                } else {
                    num.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
//            System.out.println();
            result.add(num);
        }
        return result;
    }

    public static BigDecimal getRowNumB(BigDecimal n, BigDecimal m) {
        List<BigDecimal> rowCount = new ArrayList<BigDecimal>(Integer.valueOf(n.toString()));
        rowCount.add(BigDecimal.ONE);
        for (int i = 1; i <= Integer.valueOf(n.toString())-1; ++i) {
            System.out.println("-----------------------------------------------------------------------------------------"+rowCount.get(i - 1));
            System.out.println(n.subtract(BigDecimal.ONE).subtract(BigDecimal.valueOf(i)).pow(1));
//            System.out.println(rowCount.get(i - 1));
//            System.out.println(rowCount.get(i - 1));
//            System.out.println(rowCount.get(i - 1));
            rowCount.add(rowCount.get(i - 1).multiply((n.subtract(BigDecimal.ONE).subtract(BigDecimal.valueOf(i)).pow(1)).divide(BigDecimal.valueOf(i))));
        }
        return rowCount.get(Integer.valueOf(m.toString())-1);
    }

    public static int getRowNum(int n,int m) {
        List<Integer> rowCount = new ArrayList<Integer>();
        rowCount.add(1);
        for (int i = 1; i <= n-1; ++i) {
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+rowCount.get(i - 1));
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

        System.err.println(getRowNum(7,5));

//        String input = scanner.nextLine();
//        String[] nums = input.split(" ");
//        System.err.println(getRowNum(Integer.valueOf(nums[0]),Integer.valueOf(nums[1])));

//        System.out.println(generate(11));
        System.err.println(getRowNumB(BigDecimal.valueOf(7),BigDecimal.valueOf(5)));
        //System.lineSeparator()
        System.out.println(generate(11).toString().replaceAll("\\[","").replaceAll("\\],",System.lineSeparator()).replaceAll("\\]]",""));
    }
}
