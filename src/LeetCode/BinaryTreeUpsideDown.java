package LeetCode;

/**
 * Created by yuliu on 9/14/16.
 * Given a binary tree where all right nodes are either leaf nodes with a sibling or empty.
 * flip it upside down and turn it into a tree
 * return the new root
 */
public class BinaryTreeUpsideDown {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
//recursive
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    //iterative
    public TreeNode upsideDown2(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode prevLeft = null;
        TreeNode prevRight = null;
        TreeNode cur = root;
        while(cur != null) {
            TreeNode left = cur.left;
            TreeNode right = cur.right;

            cur.left = prevLeft;
            cur.right = prevRight;

            prevLeft = right;
            prevRight = cur;

            cur = left;
        }
        return prevRight;
    }


    public static void main(String[] args) {
        BinaryTreeUpsideDown test = new BinaryTreeUpsideDown();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;

        System.out.print(test.upsideDownBinaryTree(one));

    }
}
