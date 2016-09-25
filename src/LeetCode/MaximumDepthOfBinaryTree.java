package LeetCode;

/**
 * Created by yuliu on 9/3/16.
 *///Given a binary tree, find its maximum depth, which is the # of nodes along the longest path
    //
public class MaximumDepthOfBinaryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
