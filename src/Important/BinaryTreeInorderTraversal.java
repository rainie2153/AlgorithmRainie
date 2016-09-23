package Important;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuliu on 9/2/16.
 */
public class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
/*底下错误的原因是res每次都initialized when you call the function recursively so you should add the whole Arraylist
* into res when doing inorderTraveral to the left and inorderTraversal to the right. In java, if we define an Arraylist beforehand
* when you call the function recursively we need to use list.addAll*/

    //Method1.1 recursion

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();
        if (root == null) {
            return res2;
        }
        res2.addAll(inorderTraversal(root.left));
        res2.add(root.val);
        res2.addAll(inorderTraversal(root.right));
        return res2;
    }
    //---------------以上为正确是要用到addAll这个API才能把结果给加进去
    // 下面是常规的正确解
    //Method1.2 recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    //Method 2 Iteration use stack 跟recursive 的时空都是一样都是O(n)
    public List<Integer> inorder3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!= null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;

    }

    //Method 3 Morris Traversal O(n) time O(1) space
    public List<Integer> inorderMorris(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode predecessor = cur.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            if (predecessor.right == null) {
                predecessor.right = cur;
                cur = cur.left;
            } else {
                predecessor.right = null;
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
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
        System.out.print(test.inorderTraversal(ten));

    }
}


