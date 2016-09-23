package basic1;

/**
 * Created by yuliu on 3/15/16.
 */
public class SymmetricBinaryTree {
    //对称树
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode (int key) {
            this.key = key;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (left.key != right.key) return false;
        else return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
