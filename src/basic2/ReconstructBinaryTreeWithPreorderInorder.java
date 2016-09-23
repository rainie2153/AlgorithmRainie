package basic2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 7/1/16.
 */
//Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree
    //The given sequences are not null and they have the same length
    //there are no duplicate keys in the binary tree
    //preorder traversal = {}
    //inoder
public class ReconstructBinaryTreeWithPreorderInorder {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    //Method1: Utilizing inorder sequence to determine the size of left/right subtree
    public TreeNode reconstruct(int[] in, int[] pre) {
        Map<Integer, Integer> inIndex = indexMap(in);
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }
    private Map<Integer, Integer> indexMap(int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }
    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(root.key);
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
        return root;
    }

}
