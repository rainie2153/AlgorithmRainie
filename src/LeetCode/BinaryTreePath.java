package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/29/16.
 */
public class BinaryTreePath {

        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "");
        dfs(root, sb, res);
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        int len = sb.length();
        if (root.left == null && root.right == null) {
            res.add(new String(sb));
            return;
        }
        if (root.left != null) {
            sb.append("->" + root.left.val);
            dfs(root.left, sb, res);
            sb.setLength(len);
        }
        if (root.right != null) {
            sb.append("->" + root.right.val);
            dfs(root.right, sb, res);
            sb.setLength(len);
        }
    }
    public static void main(String[] args) {
        BinaryTreePath test = new BinaryTreePath();
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
        test.binaryTreePaths(ten);

    }
}
