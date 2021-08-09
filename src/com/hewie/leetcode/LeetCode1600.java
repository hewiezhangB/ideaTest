package com.hewie.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1600 {
    class ThroneInheritance {
        class Node {
            String name;
            Node next;
            Node last; // 记录最后一个儿子
            boolean isDeleted = false;
            Node (String _name) {
                name = _name;
            }
        }
        Map<String, Node> map = new HashMap<>();
        Node head = new Node(""), tail = new Node("");
        public ThroneInheritance(String name) {
            Node root = new Node(name);
            root.next = tail;
            head.next = root;
            map.put(name, root);
        }

        public void birth(String pname, String cname) {
            Node node = new Node(cname);
            map.put(cname, node);
            Node p = map.get(pname);
            Node tmp = p;
            while (tmp.last != null) tmp = tmp.last;
            node.next = tmp.next;
            tmp.next = node;
            p.last = node;
        }

        public void death(String name) {
            Node node = map.get(name);
            node.isDeleted = true;
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            Node tmp = head.next;
            while (tmp.next != null) {
                if (!tmp.isDeleted) ans.add(tmp.name);
                tmp = tmp.next;
            }
            return ans;
        }
    }
}
