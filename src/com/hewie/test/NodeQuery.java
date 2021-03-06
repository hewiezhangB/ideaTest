package com.hewie.test;

public class NodeQuery {
    public static void preOrder(NodeTree root) { // 先根遍历
        if (root != null) {
            System.out.print(root.data + "-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(NodeTree root) { // 中根遍历

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }

    public static void postOrder(NodeTree root) { // 后根遍历
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---");
        }
    }
    public static void main(String[] args) {
        int[] array = {35,17,39,9,28,65,56,87};
        //创建二叉树
        NodeTree root = new NodeTree(array[0]);
        for(int i=1;i<array.length;i++){
            //向二叉树中插入数据
            root.insert(root, array[i]);
        }
        System.out.println("先根遍历：");
        preOrder(root);
		/*  System.out.println();
		  System.out.println("中根遍历：");
		  inOrder(root);
		  System.out.println();
		  System.out.println("后根遍历：");
		  postOrder(root);*/
    }
}
