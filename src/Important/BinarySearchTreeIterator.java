package Important;

import java.util.Stack;

/**
 * Created by yuliu on 9/15/16.
 * Implement a iterator
 * next() return the next smallest number in the BST
 * hasNext() return
 */
public class BinarySearchTreeIterator {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur;
    public BinarySearchTreeIterator(TreeNode root) {//constructor
        this.cur = root;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public int next(){
        int res = 0;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        if (!stack.isEmpty()) {
            cur = stack.pop();
            res = cur.val;
            cur = cur.right;
        }
        return res;
    }

}
