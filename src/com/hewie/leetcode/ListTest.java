package com.hewie.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args){
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");
        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");
        new ListTest().chaji(list1,list2);
    }

    // 交集
    public void jiaoji(List<String> list1,List<String> list2){
        List<String> intersection = list1.stream().filter(item ->   list2.contains(item)).collect(Collectors.toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);
    }

    // 差集 (list1 - list2)
    public void chaji(List<String> list1,List<String> list2){
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        String aa = "W3siZGVzY3JpcHRpb24iOiIiLCJrZXkiOiIxIiwib3BlcmF0aW9ubW9kZSI6IkNPUFkiLCJ2YWx1ZSI6IiJ9LHsiZGVzY3JpcHRpb24iOiIiLCJrZXkiOiIyIiwib3BlcmF0aW9ubW9kZSI6IklOU0VSVCIsInZhbHVlIjoiIn1d";
        Base64.getDecoder().decode(aa);
        Base64.getDecoder().decode(aa.getBytes(StandardCharsets.UTF_8));
        //new String(Base64.getDecoder().decode(aa.getBytes(StandardCharsets.UTF_8)))
        System.err.println(new String(Base64.getDecoder().decode(aa)));
    }

    // 差集 (list2 - list1)
    public void chajito(List<String> list1,List<String> list2){
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);
    }

    // 并集
    public void binji(List<String> list1,List<String> list2){
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);
    }

    // 去重并集
    public void quchongjiaoji(List<String> list1, List<String> list2){
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out::println);

    }


}
