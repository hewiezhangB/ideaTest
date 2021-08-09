package com.hewie.huaw;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 序列化是指将一个数据结构转化为位序列的过程，因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
 *
 * 设计一个序列化和反序列化 N 叉树的算法。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。序列化 / 反序列化算法的算法实现没有限制。你只需要保证 N 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
 *
 * 例如，你需要序列化下面的 3-叉 树。
 *
 * 为 [1 [3[5 6] 2 4]]。你不需要以这种形式完成，你可以自己创造和实现不同的方法。
 * */
public class LeetCode428 {
        /**
         * 序列化：将二叉树前序遍历，每个子树由[]表示
         * 如题目中给出的示例序列化后变为：1[3[5][6]][2][4]
         * Encodes a tree to a single string.
         * */
        public String serialize(Node root) {
            //前序遍历
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            return sb.substring(1, sb.length() - 1);
        }

        /**前序遍历*/
        private void helper(Node root, StringBuilder sb) {
            if(root==null){return;}
            sb.append("[");
            sb.append(root.val);
            if(root.children!=null){
                for(Node node:root.children){
                    helper(node,sb);
                }
            }
            sb.append("]");
        }

        // 1[3[5][6]][2][4]
        // 创建一个Stack用来保存节点。遍历字符串，如果出现数字，则创建新节点，如果Stack不为空，则获取顶层元素，
        //加入顶层元素的child中，然后压栈。如果遇到']'则弹栈，直至遍历完字符串。树的元素没有负数，则不需要考虑别的情况。
        public Node deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            Stack<Node> stack = new Stack();
            for(int i=0;i<data.length();){
                if(data.charAt(i)>='0'&&data.charAt(i)<='9'){
                    String temp = "";
                    while(i<data.length()&&data.charAt(i)>='0'&&data.charAt(i)<='9'){
                        temp += data.charAt(i);
                        i++;
                    }
                    int cur = Integer.parseInt(temp);
                    Node t = new Node(cur,new ArrayList<Node>());
                    // 不为root节点
                    if(!stack.isEmpty()){
                        Node par = stack.peek();
                        if(par.children==null){
                            par.children = new ArrayList<Node>();
                        }
                        par.children.add(t);
                    }
                    stack.push(t);
                }
                if(i<data.length()&&data.charAt(i)==']'){
                    stack.pop();
                }
                i++;
            }
            if (stack.isEmpty()) {
                return null;
            }
            return stack.peek();
        }

        class Node{
            private int val;
            private List<Node> children;
            public Node() {
            }
            public Node(int val, List<Node> children) {
                this.val = val;
                this.children = children;
            }
        }
}
