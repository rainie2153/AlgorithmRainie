package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 9/20/16.
 * The root is the top element in the stack
 * maintain a previous node, to record the previous visiting node on the traversing path, so that we know what
 * direction we are taking now and what is the direction we are taking next
 * root = stack.top
 * if previous is null going down left subtree has priority
 * if previous is current's parent go down left subtree has priority
 * if previous is cur.left  left subtree finished, going cur.right
 * if previous is cur.right right subtree finished, pop cur, going up
 */
public class PostOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if(cur.right != null) {
                    stack.push(cur.right);
                } else {
                    System.out.println(cur.val);
                    stack.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    System.out.println(cur.val);
                    stack.pop();
                }
            } else {
                System.out.println(cur.val);
                stack.pop();
            }
            prev = cur;
        }

    }

    public static void main(String arg[]) {
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;

        PostOrderTraversal test = new PostOrderTraversal();
        test.postOrder(ten);
    }


}
