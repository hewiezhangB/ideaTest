package com.hewie.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer,Integer> Cache;
    public LRUCache(int capacity) {
        //以正整数作为容量 capacity 初始化 LRU 缓存
        this.capacity = capacity;
        Cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        if(!Cache.containsKey(key)){
            return -1;
        }
        Integer value = Cache.remove(key);
        Cache.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        //如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
        // 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
        if(Cache.containsKey(key)){
            Cache.remove(key);
            Cache.put(key,value);
            return;
        }
        Cache.put(key,value);
        if(Cache.size() > capacity){
            Cache.remove(Cache.entrySet().iterator().next().getKey());
        }
    }
}
