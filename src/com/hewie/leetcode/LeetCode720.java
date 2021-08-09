package com.hewie.leetcode;

import java.util.*;

public class LeetCode720 {
    /*public static String longestWord(String[] words) {
        Map<Integer,String> record = new HashMap<Integer,String>();
        for (String word:words) {
            record.put(words.length,word);
        }
        List<Map.Entry<Integer,String>> mapList = new ArrayList<>(record.entrySet());
        Collections.sort(mapList,(m,n) -> (m.getKey()-n.getKey()));
        return mapList.get(mapList.size()-1).getValue();

//        Optional<Map.Entry<Integer, String>> newRecord = record.entrySet().stream().max(Map.Entry.comparingByValue());
//        return newRecord.get().getValue();
    }*/
    public static String longestWord(String[] words) {
        /*Set<String> wordset = new HashSet();
        for (String word: words) {
            wordset.add(word);
        }
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word: words) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) {
                return word;
            }
        }
        return "";*/
        Set<String> wordSet = new HashSet<>();
        for (String word:words) {
            wordSet.add(word);
        }
        Arrays.sort(words,(a,b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String word:words) {
            boolean isWord = true;
            for (int i = 1; i < word.length(); i++) {
                if(!wordSet.contains(word.substring(0,i))) {
                    isWord = false;
                    break;
                }
            }
            if(isWord){
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words3 = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        String[] words4 = {"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"};
        System.out.println(longestWord(words));
        System.out.println(longestWord(words2));
        System.out.println(longestWord(words3));
        System.out.println(longestWord(words4));
    }
}
