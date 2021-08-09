package com.hewie.leetcode;

public class LeetCode1319 {
    int[] element;
    int count;
    public int makeConnected(int n, int[][] connections) {
       if(connections.length < n-1){
           return -1;
       }
       this.element = new int[n];
       this.count = n;
        for (int i = 0; i < element.length; i++) {
            element[i] = i;
        }
        for (int[] e: connections) {
            host(e[0],e[1]);
        }
        return count - 1;
    }
    int find(int x){
        if(element[x] == x){
            return x;
        }
        element[x] = find(element[x]);
        return element[x];
    }
    void host(int x,int y){
        int xi = find(x);
        int yi = find(y);
        if(xi == yi){
            count --;
            element[xi] = yi;
        }
    }
}
