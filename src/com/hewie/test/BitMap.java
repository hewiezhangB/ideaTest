package com.hewie.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitMap {
    private int[] sign = {0x00000001,0x00000002,0x00000004,0x00000008,0x00000010,0x00000020,0x00000040,0x00000080,0x00000100,0x00000200,0x00000400,0x00000800,0x00001000,0x00002000,0x00004000,0x00008000,
            0x00010000,0x00020000,0x00040000,0x00080000,0x00100000,0x00200000,0x00400000,0x00800000,0x01000000,0x02000000,0x04000000,0x08000000,0x10000000,0x20000000,0x40000000,0x80000000};

    private int[] arr ;

    private int capacity;

    public BitMap(int capacity) {
        validate(capacity);
        this.capacity = capacity;
        this.arr = new int[(capacity>>5)+1];
    }

    public void put(int k){
        if ( k > capacity ){
            throw new RuntimeException("k is greater than capacity");
        }
        validate(k);
        //当前数字应该存放的bucket索引
        int index = k >> 5 ;
        arr[index] = arr[index]|sign[k & 31];

    }


    private void validate(int k){
        if ( k <= 0 ){
            throw new IllegalArgumentException(" capacity must be greater than zero");
        }
    }


    public int[] getMixed(BitMap bitMap){
        int length = Math.min(bitMap.arr.length,this.arr.length);
        int[] other = new int[length],me = new int[length];
        System.arraycopy(bitMap.arr,0,other,0,length);
        System.arraycopy(this.arr,0,me,0,length);
        //借用集合的无固定大小来构建最后数组
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int k= other[i] & me[i];
            for (int j = 1; j <= 32; j++) {
                if ( ((k>>j)&1) == 1 ){
                    result.add((i<<5)+j);
                }
            }
        }
        if ( result.size() == 0 ){
            return null;
        }else {
            int[] rs = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                rs[i] = result.get(i);
            }
            return rs;
        }

    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(1000){{
            put(248);
            put(5);
            put(9);
            put(12);
            put(6);
            put(13);
            put(963);

        }};
        BitMap bitMap1 = new BitMap(1000){{
            put(248);
            put(15);
            put(13);
            put(963);
            put(5);
            put(6);
            put(9);

        }};
        int[] mixed = bitMap.getMixed(bitMap1);
        System.out.println(Arrays.toString(mixed));
    }
}
