package LeetCode;

/**
 * Created by yuliu on 9/3/16.
 * Implement set 的一个好办法 可以用binary search tree来implement
 * insert a key in a binary search tree if the binary search tree does not already contain the key
 * return the root of the binary search tree
 *
 * Assumption: Set
 * 1.there are no duplicate keys
 * 2.if the key is already exists, you dont have to do any thing
 */
public class BinarySearchTreeInsertion {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            if (key > cur.val) {
                parent = cur;
                cur = cur.right;
            } else if (key < cur.val){
                parent = cur;
                cur = cur.left;
            } else {
                return root;
            }
        }

        if (cur == null) {
            if (key > parent.val) {
                parent.right = new TreeNode(key);
            } else {
                parent.left = new TreeNode(key);
            }
        }
        return root;
    }

}
