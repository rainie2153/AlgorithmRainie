package LeetCode;

/**
 * Created by yuliu on 9/3/16.
 */
public class FlattenBinaryTreeToLinkedList {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        if (root.left == null) {
            return;
        } else {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = root.left;

            root.left = null;
        }
    }
}
