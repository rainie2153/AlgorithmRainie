package Important;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 9/3/16.
 */
public class BinaryTreeLevelOrderTraversal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            res.add(ans);
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode eleven = new TreeNode(11);
        TreeNode fourteen = new TreeNode(14);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;
        twelve.left = eleven;
        twelve.right = fourteen;
        System.out.print(test.levelOrder(ten));

    }
}
