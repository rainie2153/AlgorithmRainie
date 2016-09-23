package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 7/27/16.
 */
public class KthSmallestBST {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                if (k == 1) return curr.key;
                curr = curr.right;
                k--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestBST test = new KthSmallestBST();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode fourteen = new TreeNode(14);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;
        twelve.left = eleven;
        twelve.right = fourteen;
        System.out.print(test.kthSmallest(ten, 5));

    }
}
