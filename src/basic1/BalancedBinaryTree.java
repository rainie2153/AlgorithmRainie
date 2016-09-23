package basic1;

/**
 * Created by yuliu on 3/15/16.
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode (int key) {
            this.key = key;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftheight = getHeight(root.left);
        int rightheight = getHeight(root.right);
        return 1 + Math.max(leftheight, rightheight);
    }
    public static void main(String[] args) {
        BalancedBinaryTree test = new BalancedBinaryTree();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode eleven = new TreeNode(11);

        ten.left = seven;
        seven.left = twelve;
        twelve.left = two;
        ten.right = five;
        five.right = eleven;

        System.out.print(test.isBalanced(ten));

    }
}

