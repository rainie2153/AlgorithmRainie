package Important;

import java.util.*;

/**
 * Created by yuliu on 9/3/16.
 */
//Bottom up的区别是本来是用list来保存结果，现在可以把list of nodes用一个stack来保存然后最后返回回来
public class BinaryTreeLevelOrderTraversalII {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return (List<List<Integer>>)res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            res.push(ans);
        }
        return (List<List<Integer>>) res;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII test = new BinaryTreeLevelOrderTraversalII();
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
        System.out.print(test.levelOrderBottom(ten));

    }

}
