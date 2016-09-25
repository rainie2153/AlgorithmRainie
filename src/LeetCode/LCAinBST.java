package LeetCode;

/**
 * Created by yuliu on 9/21/16.
 * 区别再去如何用到BST的性质 当然用之前的binary tree的LCA也是可以解决但就是没有用到大小关系
 * 判断大小 LCA在[a,b]之间
 * 假设一上来的值不再区间内 就直接不用再check了 logN
 */
public class LCAinBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode lcaBST(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }
        if(root.val > a.val && root.val > b.val) {//在［a,b］区间内
            return lcaBST(root.left, a, b);
        } else if (root.val < a.val && root.val < b.val){
            return lcaBST(root.right, a, b);
        } else {
            return root;
        }
    }
}
