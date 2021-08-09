package com.hewie.leetcode;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return searchTree(preorder,0,preorder.length - 1,inorder,0,inorder.length -1);
    }

    public TreeNode searchTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        int idx = inLeft,val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == val){
                idx = i;
                break;
            }
        }
        root.left = searchTree(preorder,preLeft + 1,preLeft + (idx - inLeft),inorder,inLeft,idx - 1);
        root.right = searchTree(preorder,preLeft + (idx - inLeft) + 1,preRight,inorder,idx + 1,inRight);
        return root;
    }
}
