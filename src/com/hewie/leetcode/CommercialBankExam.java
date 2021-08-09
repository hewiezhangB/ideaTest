package com.hewie.leetcode;

public class CommercialBankExam {
    public static void main(String[] args) {
        primeNumber();  //求101到等于200的素数
        for (int i = 1; i <= 100; i++) {
            if (narcissisticNumber(i)) {
                System.out.print(System.lineSeparator() + i+ ":是水仙花数字");
            }
        }
    }
    private static void primeNumber(){
        for (int i = 101; i <= 200; i++) {
            boolean flag = false;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.err.print(i + " ");
            }
        }
    }

    private static boolean narcissisticNumber(int num){
        //百位
        int i = num / 100;
        //十位
        int j = num % 100 / 10;
        int k = num - i * 100 - j * 10;
        if(num == i*i*i + j*j*j + k*k*k){
            return true;
        }
        return false;
    }
}
