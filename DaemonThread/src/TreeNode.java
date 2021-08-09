public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
        //初始化数
        this.left = null;
        this.right = null;
    }

    public void insertData(TreeNode root,int data) {
        //如果左节点为空
        if(root.left == null){
            //创建左节点
            TreeNode treeNode = new TreeNode(data);
        } else {
            insertData(root.left,data);
        }
    }
}


