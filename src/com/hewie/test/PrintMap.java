package com.hewie.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PrintMap {
    static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(1,"test");
        map.put(2,"test2");
        map.put(3,"test3");
        map.put(4,"test4");
        map.put(5,"test5");
        map.put(6,"test6");

        map.forEach((k,v) -> {
            System.err.println("k:" + k +"v:" +v);
        });

        for (Integer test : map.keySet()){
            System.err.println("k:" + test + "v:" + map.get(test));
        }

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> s:set) {
            System.err.println("k:"+s.getKey()+"v:"+s.getValue());
        }

        for (String s: map.values()) {
            System.err.println("v:" + s);
        }

        System.out.println(map.entrySet().iterator().next().getKey());
    }
}
