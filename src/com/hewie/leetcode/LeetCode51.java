package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] charNum = new char[n][n];
        for (char[] c:charNum) {
            Arrays.fill(c,'.');
        }
        backLoop(n,0,charNum);
        return result;
    }

    private List combineList(char[][] charNum){
        List<String> list = new ArrayList<>();
        for (char[] c:charNum) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private void backLoop(int n,int row,char[][] charNum){
        if(row == n){
            result.add(combineList(charNum));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if(isValiue(n,row,charNum,col)){
                charNum[row][col] = 'Q';
                backLoop(n,row + 1,charNum);
                charNum[row][col] = '.';
            }
        }
    }

    private boolean isValiue(int n,int row,char[][] charNum,int col){
        for (int i = 0; i < n; i++) {
            if(charNum[i][col] == 'Q'){
                return false;
            }
        }

        //45度对角线
        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if(charNum[i][j] == 'Q'){
                return false;
            }
        }

        //135度对角线
        for (int i = row - 1,j = col + 1; i >= 0 && j <= n - 1; i--,j++) {
            if(charNum[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();
        System.out.println(leetCode51.solveNQueens(4));
//        System.out.println(leetCode51.solveNQueens(1));
    }
}
