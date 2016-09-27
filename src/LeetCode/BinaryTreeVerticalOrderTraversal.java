package LeetCode;
import java.util.*;
/**
 * Created by yuliu on 9/25/16.
 */
public class BinaryTreeVerticalOrderTraversal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }


    int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getMinAndMax(root, 0);//这道题要特别注意找min max 否则有些特例不能通过 important

        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<Integer>());
        }

        //begin level order traverse
        Queue<TreeNode> treeQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        treeQ.offer(root);
        indexQ.offer(-min);

        while (!treeQ.isEmpty()) {
            TreeNode curr = treeQ.poll();
            int currIdx = indexQ.poll();

            res.get(currIdx).add(curr.val);//当前index为与min的对称就是－min,min本身是个负数

            if (curr.left != null) {
                treeQ.offer(curr.left);
                indexQ.offer(currIdx - 1);
            }

            if (curr.right != null) {
                treeQ.offer(curr.right);
                indexQ.offer(currIdx + 1);
            }
        }

        return res;
    }

    public void getMinAndMax(TreeNode root, int hd) {//level就是水平距离horization distance
        if (root == null) {
            return;
        }


        min = Math.min(min, hd);
        getMinAndMax(root.left, hd - 1);
        getMinAndMax(root.right, hd + 1);
        max = Math.max(max, hd);
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal test = new BinaryTreeVerticalOrderTraversal();
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
        System.out.print(test.verticalOrder(ten));

    }
}
