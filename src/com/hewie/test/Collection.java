package com.hewie.test;

import java.util.*;
import java.util.stream.Collectors;

public class Collection {

    /**
     * 简单类型的处理
     */
    public static void showSimpleDeal() {
//        int[] arr = {1,2,3};
        //Collectors.toList()
//        Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList<>();
        list2.add("3333");
        list2.add("4444");

        Set<String> list1Set = new HashSet<>(list1);

        Set<String> list2Set = new HashSet<>(list2);

        // 交集
        List<String> intersection = list1.stream().filter(list2Set::contains).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out::println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2Set.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out::println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1Set.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out::println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out::println);

        // 去重并集
        list1Set.addAll(list2Set);
        List<String> listDistinctAll = new ArrayList<>(list1Set);
        System.out.println("---得到去重并集 listDistinctAll---");
        listDistinctAll.parallelStream().forEach(System.out::println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEach(System.out::println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] vertexs = { 1, 2, 3, 4, 5 };
        //5, 6,7, 8, 9
        int[] vertexsSpare = {5, 6,7, 8, 9};
        System.arraycopy(vertexs, 0, vertexsSpare, 0, vertexs.length);
        System.out.println(Arrays.toString(vertexsSpare));
//        showSimpleDeal();
    }
}
