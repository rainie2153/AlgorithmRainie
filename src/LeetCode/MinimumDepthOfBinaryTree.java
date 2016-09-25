package LeetCode;/*
 * Created by yuliu on 9/3/16.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *///O(n) time complexity O(1)

public class MinimumDepthOfBinaryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return 1 + Math.min(left, right);
    }

}
