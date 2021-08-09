package com.hewie.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode451 {
    class Node {
        char c;
        int v;
        public Node(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c: cs) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a,b) -> {
            if(b.v != a.v){
                return b.v - a.v;
            }
            return  a.c - b.c;
        });
        for (char c:map.keySet()) {
            queue.add(new Node(c,map.get(c)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int k = poll.v;
            while (k-- > 0){
                stringBuilder.append(poll.c);
            }
        }
        return stringBuilder.toString();
    }
}
