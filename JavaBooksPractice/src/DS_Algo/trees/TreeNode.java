package DS_Algo.trees;

import java.lang.annotation.Documented;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right =null;
    }


    /**
     * This function will build a tree and return its root.
     * Level order as : 5|2,8|1 3 7 9
     *
     * @return he root of the binary tree
     *

     */
    public static TreeNode getTree(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        return root;
    }
}
