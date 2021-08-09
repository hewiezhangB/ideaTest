package com.hewie.leet;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Leet617 {
    public TreeNode1 mergeTrees(TreeNode1 root1, TreeNode1 root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode1 newTreeNode = new TreeNode1(root1.val + root2.val);
        newTreeNode.left = mergeTrees(root1.left,root2.left);
        newTreeNode.right = mergeTrees(root1.right,root2.right);
        return newTreeNode;
    }
}
