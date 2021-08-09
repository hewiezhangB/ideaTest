package com.hewie.leetcode;

import java.util.*;

public class LeetCode692 {
    public class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            //使用哈希表统计单词出现的概率
            Map<String,Integer> wordCount = new HashMap<>();
            for (String word: words) {
                wordCount.put(word,wordCount.getOrDefault(word,0) + 1);
            }
            //使用最小堆排序
            PriorityQueue<String> minHeap = new PriorityQueue<String>((e1,e2) -> {
                if(wordCount.get(e1).equals(wordCount.get(e2))){
                    return e2.compareTo(e1);
                } else {
                    return wordCount.get(e1) - wordCount.get(e2);
                }
            });
            //向堆中加入元素
            for (String ele: wordCount.keySet()) {
                minHeap.offer(ele);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            }
            List<String> result = new ArrayList<>(k);
            while (minHeap.size() > 0){
                result.add(minHeap.poll());
            }
            Collections.reverse(result);
            return result;
        }
    }

}
