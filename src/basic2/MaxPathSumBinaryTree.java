package basic2;

/**
 * Created by yuliu on 6/29/16.
 */
// Given a binary tree which each node contains an integer number. Find the maximum possible sum from one
    //leaf node to another leaf node. If there is no such path avaliable return integer.MIN_Value
public class MaxPathSumBinaryTree {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        maxSumHelper(root, max);
        return max[0];
    }
    private int maxSumHelper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxSumHelper(root.left, max);
        int right = maxSumHelper(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + root.key);
            return Math.max(left, right) + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }

}
