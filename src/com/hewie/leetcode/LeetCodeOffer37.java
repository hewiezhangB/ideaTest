package com.hewie.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*Definition for a binary tree node.*/
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}*/
public class LeetCodeOffer37 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serilise(root,"");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] array = data.split(",");
            List<String> dataList = new LinkedList<>(Arrays.asList(array));
            return deserilise(dataList);
        }

        private String serilise(TreeNode root,String str){
            if(root == null){
                str += "None,";
            } else {
                str += String.valueOf(root.val) + ",";
                str = serilise(root.left,str);
                str = serilise(root.right,str);
            }
            return str;
        }

        private TreeNode deserilise(List<String> data){
//            if(data.size() == 0){
//                return null;
//            }
            if(data.get(0).equals("None")){
                data.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
            data.remove(0);
            root.left = deserilise(data);
            root.right = deserilise(data);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//    public String serialize(TreeNode root) {
//        return rserialize(root, "");
//    }
//
//    public TreeNode deserialize(String data) {
//        String[] dataArray = data.split(",");
//        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
//        return rdeserialize(dataList);
//    }
//
//    public String rserialize(TreeNode root, String str) {
//        if (root == null) {
//            str += "None,";
//        } else {
//            str += str.valueOf(root.val) + ",";
//            str = rserialize(root.left, str);
//            str = rserialize(root.right, str);
//        }
//        return str;
//    }
//
//    public TreeNode rdeserialize(List<String> dataList) {
//        if (dataList.get(0).equals("None")) {
//            dataList.remove(0);
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
//        dataList.remove(0);
//        root.left = rdeserialize(dataList);
//        root.right = rdeserialize(dataList);
//
//        return root;
//    }

}
