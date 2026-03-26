package DS_Algo.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        levelWise(root);
    }

    public static void level(TreeNode root){
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.println(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }

    }

    public static void levelWise(TreeNode root){
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        int lev = 0;
        while(!q.isEmpty()){
            int size = q.size();
            System.out.print("Level "+lev+": ");
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                System.out.print(node.val+" ");
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            lev++;
            System.out.println();
        }
    }
}
