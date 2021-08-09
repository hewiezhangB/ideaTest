package com.hewie.leetcode;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        val = val;
    }

    public Node(int val, List<Node> children,Node left, Node right, Node next) {
        val = val;
        children = children;
        left = left;
        right = right;
        next = next;
    }
}
