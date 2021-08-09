package com.hewie.leet;

public class Leet509 {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        int a = 0,b = 1,c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Leet509().fib(2));
    }
}
