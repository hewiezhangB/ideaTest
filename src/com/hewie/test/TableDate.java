package com.hewie.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 表驱动法编程 2021-05-26 13:43:32
 * */
public class TableDate {
    // 原来的代码
//    if( (a && !c ) || (a && b && c)){
//        category = 1 ;
//    }else if( (b && ! a) || (a && c && !b)){
//        category = 2 ;
//    }else if ( c && !a && !b){
//        category = 3 ;
//    }else {
//        category = 0 ;
//    }
    static int categoryTable[][]  ={
            //!b!c   !bc    b!c   bc
            {0,       3,     2,    2},// !a
            {1,       2,     1,    1} // a
    };
    public static void main(String[] args) {
        //直接访问表
        String[] weekdays = new String[]{"周六","周日","周一","周二","周三","周四","周五"};
        System.out.println(weekdays[31 % 7]);

        // 转换为 ( 这里 是 三维 的结果转成二维 去存放)
        int category = categoryTable[1][0];
        System.err.println(category);

        Map<String,Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        //第一种方法
        Optional<Map.Entry<String, Integer>> max0 = map.entrySet().stream().max(Map.Entry.comparingByValue());
        //第二种方法
        Optional<Map.Entry<String, Integer>> max1 = map.entrySet().stream().max((x1, x2) -> Integer.compare(x1.getValue(), x2.getValue()));

        System.out.println(max1.get().getKey());

        //第三种方法
        Optional<Map.Entry<String, Integer>> max3 = map.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue()));


        //第四种方法
        Optional<Map.Entry<String, Integer>> max4 = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));

        //第五种方法
        IntSummaryStatistics max5 = map.entrySet().stream().collect(Collectors.summarizingInt(Map.Entry::getValue));


        Map<String, Integer> map1 = new HashMap();
        map.put("1", 8);
        map.put("2", 12);
        map.put("3", 53);
        map.put("4", 33);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);
        List<Map.Entry<String,Integer>> list = new ArrayList(map1.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
    }
}
