package com.hewie.leetcode;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        findNum(board);
    }

    private boolean findNum(char[][] board){
        //行
        for (int i = 0; i < 9; i++) {
            //列
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if(isValied(i,j,k,board)){
                        board[i][j] = k;
                        if(findNum(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValied(int row,int col,char value,char[][] board){
        //同行是否重复
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == value){
                return false;
            }
        }
        //同列是否重复
        for (int j = 0; j < 9; j++) {
            if(board[j][col] == value){
                return false;
            }
        }
        //九宫格中的数字是否重复
        int startRow = (row / 3) * 3;
        int endCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = endCol; j < endCol + 3; j++) {
                if(board[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        LeetCode37 leetCode37 = new LeetCode37();
        leetCode37.solveSudoku(board);

    }
}
