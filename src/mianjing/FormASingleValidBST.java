package mianjing;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by yuliu on 9/24/16.
 * Given a set of TreeNodes, find if they form a single valid BST if so return the root otherwise null;
 */
public class FormASingleValidBST {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode findSingleBST(Set<TreeNode> set) {
        if (set == null || set.size() == 0) {
            return null;
        }
        Set<TreeNode> candidates = new HashSet<>(set);
        //先找到根节点再BFS遍历
        for (TreeNode tn : set) {
            if (tn.left != null) {
                candidates.remove(tn.left);
            }
            if (tn.right != null) {
                candidates.remove(tn.right);
            }
        }
        //这时candidates都是single了
        for (TreeNode root : candidates) {
            Set<TreeNode> input = new HashSet<>(set);
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            input.remove(root);
            while(!queue.isEmpty()) {
                TreeNode q = queue.poll();
                if (q.left != null) {
                    queue.offer(q.left);
                    input.remove(q.left);
                }
                if (q.right != null) {
                    queue.offer(q.right);
                    input.remove(q.right);
                }
            }
            if (input.isEmpty() && isValidBSTMethod2(root)) {
                return root;
            }
        }
        return null;
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
        FormASingleValidBST test = new FormASingleValidBST();
        TreeNode one = new TreeNode(10);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(15);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(2);
        TreeNode single = new TreeNode(999);
        one.left = two;
        one.right = three;
        two.left = four;
        four.left = five;
        Set<TreeNode> set = new HashSet<>();
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        set.add(single);
        System.out.print(test.isValidBSTMethod2(one));
        System.out.print(test.findSingleBST(set).val);
    }
}
