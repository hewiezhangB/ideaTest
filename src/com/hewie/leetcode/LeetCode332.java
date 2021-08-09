package com.hewie.leetcode;

import java.util.*;

public class LeetCode332 {
    Deque<String> result;
    private Map<String,Map<String,Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String,Map<String,Integer>>();
        result = new LinkedList<>();
        for (List<String> tagr:tickets) {
            Map<String,Integer> temp;
            if(map.containsKey(tagr.get(0))) {
                temp = map.get(tagr.get(0));
                temp.put(tagr.get(1),temp.getOrDefault(tagr.get(1),0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(tagr.get(1),1);
            }
            result.add("JFK");
            backLoop(tickets.size());
            map.put(tagr.get(0),temp);
        }
        return new ArrayList<>(result);
    }

    private boolean backLoop(int targetNum){
//        if(result.size() == targetNum + 1){
//            return false;
//        }
//        String last = result.getLast();
//        if(map.containsKey(last)){
//            for (Map.Entry<String,Integer> target:map.get(last).entrySet()) {
//                int count = target.getValue();
//                if(count > 0){
//                    result.add(target.getKey());
//                    target.setValue(count - 1);
//                    if (backLoop(targetNum)){
//                        return true;
//                    }
//                    result.removeLast();
//                    target.setValue(count);
//                }
//            }
//        }
//        return false;
        if(result.size() == targetNum + 1){
            return true;
        }
        String last = result.getLast();
        //防止出现null
        if(map.containsKey(last)){
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    result.add(target.getKey());
                    target.setValue(count - 1);
                    if(backLoop(targetNum)) {
                        return true;
                    }
                    result.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

}
