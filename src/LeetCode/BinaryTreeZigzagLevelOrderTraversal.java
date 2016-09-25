package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 9/3/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean odd = true;//from right
        while (!deque.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (odd) {//from right
                    TreeNode temp = deque.pollLast();
                    ans.add(temp.val);
                    if (temp.left != null) {
                        deque.offerFirst(temp.left);
                    }
                    if (temp.right != null) {
                        deque.offerFirst(temp.right);
                    }
                } else {//from left
                    TreeNode temp = deque.pollFirst();
                    ans.add(temp.val);
                    if (temp.right != null) {
                        deque.offerLast(temp.right);
                    }
                    if (temp.left != null) {
                        deque.offerLast(temp.left);
                    }
                }
            }
            res.add(ans);
            odd = odd == true ? false : true;
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode eleven = new TreeNode(11);
        TreeNode fourteen = new TreeNode(14);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;
        twelve.left = eleven;
        twelve.right = fourteen;
        System.out.print(test.zigzagLevelOrder(ten));
        Deque<Integer> d = new LinkedList<>();
        d.offerFirst(1);
        d.offerFirst(2);
        d.offerFirst(3);
        int a = d.peekLast();

    }
}
