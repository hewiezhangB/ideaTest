package com.hewie.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericMap {
    private static <K, V> void mapIter(Map<K, V> map) {
        for (Map.Entry<K, V> kvEntry : map.entrySet()) {
            K key = kvEntry.getKey();
            V value = kvEntry.getValue();
            System.out.println(key + ":" + value);
        }
    }

//    public static void main(String[] args) {
//        Map<String, String> mapStr = new HashMap<>();
//        mapStr.put("a", "aa");
//        mapStr.put("b", "bb");
//        mapStr.put("c", "cc");
//        mapIter(mapStr);
//        System.out.println("======");
//        Map<Integer, String> mapInteger = new HashMap<>();
//        mapInteger.put(1, "11");
//        mapInteger.put(2, "22");
//        mapInteger.put(3, "33");
//        mapIter(mapInteger);
//    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        //到这里是没有任何问题的，正常的一个 集合类的添加元素
        list.add(1024);
        list.forEach(System.out::println);
        System.out.println("-------通过反射证明泛型类型编译期间被擦除-------");
        list.getClass().getMethod("add", Object.class).invoke(list, "9527");
        list.getClass().getMethod("add", Object.class).invoke(list,"3342");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("value = " + list.get(i));
        }

    }

    
}
