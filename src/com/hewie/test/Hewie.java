package com.hewie.test;

import com.google.common.collect.Sets;

import java.util.*;

public class Hewie {
    public static void main(String[] args) {
//        System.out.println("你好，世界");
//        BigDecimal bigInteger = new BigDecimal("99999999999999999999999999999");
//        bigInteger.pow(2);
//        System.out.println(bigInteger.pow(2).toString());
//        BigInteger bigInteger = new BigInteger("99999999").pow(2);
//        System.out.println(bigInteger.longValueExact());
//
//        BigDecimal bigDecimal = new BigDecimal("9999999999999");
//        Double a = null;
//        BigDecimal.valueOf(a);
//        int index = 1;
//        System.out.println((8 & 1) == 1);
//        System.out.println(834240 & 1);

//        String s = "fdsiifnslkngfs22342";
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }

        List<String> listOne = new ArrayList<>();
        listOne.add("one");
        listOne.add("two");
        listOne.add("three");
        listOne.add("four");
        listOne.add("five");

        List<String> listTwo = new ArrayList<>();
        listTwo.add("four");
        listTwo.add("five");
        listTwo.add("two");

        //保留元素
        listOne.retainAll(listTwo);
        System.out.println(listOne);
        System.err.println(listTwo);

        retainAllByGuava();
        retainAllByTwoPoint();
        retainAllByBitSet();
    }

    /**
     * 利用guava集合求交集
     */
    private static void retainAllByGuava() {
        List<Integer> txtList = new ArrayList<>();
        txtList.add(1);
        txtList.add(2);
        txtList.add(3);
        txtList.add(4);
        txtList.add(5);
        List<Integer> txtList2 = new ArrayList<>();
        txtList2.add(2);
        txtList2.add(3);
        txtList2.add(5);
        txtList2.add(6);
        txtList2.add(9);
        Set<Integer> list = new HashSet<>(txtList);
        Set<Integer> list2 = new HashSet<>(txtList2);
        Sets.SetView<Integer> intersection = Sets.intersection(list,list2);
        System.out.println(intersection);
        System.out.println("交集的个数为:" + intersection.size());
    }

    private static void retainAllByTwoPoint() {
        List<Integer> txtList = new ArrayList<>();
        List<Integer> txtList2 = new ArrayList<>();
        txtList.add(1);
        txtList.add(2);
        txtList.add(3);
        txtList.add(4);
        txtList.add(5);
        txtList2.add(2);
        txtList2.add(3);
        txtList2.add(5);
        txtList2.add(6);
        txtList2.add(9);
        Collections.sort(txtList);
        Collections.sort(txtList2);
        int count = 0;
        int m = 0;
        int n = 0;
        int length = txtList.size() + txtList2.size();
        for (int i = 0; i < length; i++) {
            if (m < txtList.size() && n < txtList2.size()) {
                if (txtList.get(m).equals(txtList2.get(n))) {
                    count++;
                    m++;
                    n++;
                } else if (txtList.get(m).compareTo(txtList2.get(n)) > 0) {
                    n++;
                } else {
                    m++;
                }
            } else if (m < txtList.size()) {
                if (txtList.get(m).equals(txtList2.get(n - 1))) {
                    count++;
                }
                m++;

            } else if (n < txtList2.size()) {
                if (txtList.get(m - 1).equals(txtList2.get(n))) {
                    count++;
                }
                n++;
            }
        }
        System.out.println("交集的个数为:" + count);
    }

    /**
     * 利用bitmap求两个list的交集
     */
    private static void retainAllByBitSet() {
        List<Integer> txtList = new ArrayList<>();
        List<Integer> txtList2 = new ArrayList<>();
        txtList.add(1);
        txtList.add(2);
        txtList.add(3);
        txtList.add(4);
        txtList.add(5);
        txtList2.add(2);
        txtList2.add(3);
        txtList2.add(5);
        txtList2.add(6);
        txtList2.add(9);
        BitSet bitSet = new BitSet(Collections.max(txtList));
        BitSet bitSet1 = new BitSet(Collections.max(txtList2));
        for (int i = 0; i < txtList.size(); i++) {
            bitSet.set(txtList.get(i));
        }
        for (int i = 0; i < txtList2.size(); i++) {
            bitSet1.set(txtList2.get(i));
        }
        bitSet.and(bitSet1);
        System.out.println("set:" + bitSet);
        System.out.println("交集的个数为:" + bitSet.cardinality());
    }

}
