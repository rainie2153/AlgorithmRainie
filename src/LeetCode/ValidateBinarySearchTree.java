package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 9/24/16.
 * Given a binary tree, determine if it is BST 越层考虑
 */
public class ValidateBinarySearchTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x) {
            this.val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
    }

    public boolean isValidBSTMethod2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode nextshouldbigger = stack.pop();
                if (prev != null && nextshouldbigger.val <= prev.val) {
                    return false;
                }
                prev = nextshouldbigger;
                cur = nextshouldbigger.right;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        ValidateBinarySearchTree test = new ValidateBinarySearchTree();
        TreeNode one = new TreeNode(10);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(15);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(2);
        one.left = two;
        one.right = three;
        two.left = four;
        four.left = five;
        System.out.print(test.isValidBSTMethod2(one));

    }
}
