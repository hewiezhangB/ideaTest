package com.hewie.test;

import com.alibaba.fastjson.JSONObject;

public class PerformanceTest {
    public static void main(String[] args) {
        Long aliJson = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < 10000; i++) {
            jsonObject.put("22","rr");
            jsonObject.put("22","jj");
        }
        System.err.println(System.currentTimeMillis() - aliJson);

        getDebugString();
    }

    private static String getDebugString(){
        Long aa = System.currentTimeMillis();
        String jsonStr = "{}";
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        for (int i = 0; i < 10000; i++) {
            jsonObject.append("11","we");
            jsonObject.append("11","hjjk");
        }
        jsonStr = jsonObject.toString();
        System.err.println(System.currentTimeMillis()-aa);
        return jsonStr;
    }
}
