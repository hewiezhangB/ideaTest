package com.hewie.leet;

import java.util.ArrayList;
import java.util.List;

public class Leet1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        int depth = (int) (Math.log(label) / Math.log(2)) + 1;
        while (label > 1){
            result.add(0,label);
            label = label / 2;
            depth --;
            int right = (int)(Math.pow(2,depth) - 1);
            int left = (int)(Math.pow(2,depth - 1));
            label = right - (label - left);
        }
        result.add(0,1);
        return result;
    }
}
