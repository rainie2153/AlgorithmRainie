package basic2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuliu on 3/17/16.
 */
public class CheckIfBinaryTreeIsComplete {
    public boolean isCompleted(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left == null) flag = true;
            else if (flag) return false;
            else queue.offer(cur.left);//flag是true 并且cur.left有孩子

            if (cur.right == null) flag = true;
            else if (flag) return false;
            else queue.offer(cur.right);
        }
        return true;
    }

    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode (int key) {
            this.key = key;
        }
    }


    public static void main(String[] args) {

        //CheckIfBinaryTreeIsComplete test = new CheckIfBinaryTreeIsComplete();
        //Queue<TreeNode> input = new LinkedList<TreeNode>();
        CheckIfBinaryTreeIsComplete test = new CheckIfBinaryTreeIsComplete();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;






    }
}


