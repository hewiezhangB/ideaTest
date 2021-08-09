package com.hewie.leet;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Leet671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null){
            return -1;
        }
        int left = root.val == root.left.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.val == root.right.val ? findSecondMinimumValue(root.right) : root.right.val;
        int min = Math.min(left,right);
        return min > 0 ? min : Math.max(left,right);
    }
}
