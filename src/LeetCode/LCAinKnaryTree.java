package LeetCode;

import java.util.List;
import java.util.Set;

/**
 * Created by yuliu on 9/21/16.
 */
public class LCAinKnaryTree {
    static class TreeNode{
        int val;
        List<TreeNode> children;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    //k叉树 2个node
    public TreeNode lcainKnaryTree(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }
        int counter = 0;
        TreeNode temp = null;
        for(TreeNode child : root.children) {
            TreeNode node = lcainKnaryTree(child, a, b);
            if(node != null) {
                counter++;
                if(counter == 2) {
                    return root;
                }
                temp = root;
            }
        }
        return temp;
    }

    //k叉树 k个node
    public TreeNode lcainKnaryTree2(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) {
            return root;
        }
        int counter = 0;
        TreeNode temp = null;
        for(TreeNode child : root.children) {
            TreeNode node = lcainKnaryTree2(child, nodes);
            if(node != null) {
                counter++;
                if(counter > 1) {
                    return root;
                }
                temp = root;
            }
        }
        return temp;
    }
}
