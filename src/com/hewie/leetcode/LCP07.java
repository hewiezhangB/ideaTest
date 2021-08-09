package com.hewie.leetcode;

import java.util.*;

public class LCP07 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] real:relation) {
            int a = real[0],b = real[1];
            Set<Integer> set = map.getOrDefault(a,new HashSet<>());
            set.add(b);
            map.put(a,set);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty() && k-- > 0){
            int size = deque.size();
            while (size-- > 0){
                int poll = deque.pollFirst();
                Set<Integer> se = map.get(poll);
                if(se == null){
                    continue;
                }
                for (int next : se){
                    deque.addLast(next);
                }
            }
        }
        int result = 0;
        while (!deque.isEmpty()){
            if(deque.pollFirst() == n - 1){
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LCP07 lcp07 = new LCP07();
//        lcp07.numWays(5,{[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]},3);
    }
}
